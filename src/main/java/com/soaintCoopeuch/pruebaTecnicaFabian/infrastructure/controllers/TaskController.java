package com.soaintCoopeuch.pruebaTecnicaFabian.infrastructure.controllers;

import com.soaintCoopeuch.pruebaTecnicaFabian.application.dto.TaskDTO;
import com.soaintCoopeuch.pruebaTecnicaFabian.application.services.ITaskService;
import com.soaintCoopeuch.pruebaTecnicaFabian.domain.entities.Task;
import com.soaintCoopeuch.pruebaTecnicaFabian.infrastructure.exceptions.ModelNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final ITaskService _taskService;
    private final ModelMapper _mapper;

    @Autowired
    public TaskController(ITaskService taskService, ModelMapper mapper) {
        this._taskService = taskService;
        this._mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable("id") Integer id) throws Exception {
        Task task = this._taskService.getById(id);

        if(task == null)
            throw new ModelNotFoundException("Id no encontrado" + id);

        TaskDTO taskDTO = this._mapper.map(task, TaskDTO.class);

        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll() throws Exception{
        List<Task> tasks = this._taskService.getAll();
        List<TaskDTO> taskDTOs = tasks.stream().map(t -> this._mapper.map(t, TaskDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(taskDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> add(@Valid @RequestBody TaskDTO taskDto) throws Exception {

        Task task = this._mapper.map(taskDto, Task.class);

        Task taskAggregate =  this._taskService.add(task);
        TaskDTO taskDTO = this._mapper.map(taskAggregate, TaskDTO.class);

        return new ResponseEntity<>(taskDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TaskDTO> update(@Valid @RequestBody TaskDTO taskDto) throws Exception {
        Task taskFindResponse = this._taskService.getById(taskDto.getId());

        if(taskFindResponse == null)
            throw new ModelNotFoundException("Id no encontrado" + taskDto.getId());

        Task task = this._mapper.map(taskDto, Task.class);
        Task taskUpdated =  this._taskService.update(task);
        TaskDTO taskUpdatedResponse = this._mapper.map(taskUpdated, TaskDTO.class);

        return new ResponseEntity<>(taskUpdatedResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Task task = this._taskService.getById(id);

        if(task == null)
            throw new ModelNotFoundException("Id no encontrado" + id);

        this._taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
