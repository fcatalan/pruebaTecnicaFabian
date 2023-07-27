package com.soaintCoopeuch.pruebaTecnicaFabian.application.services;

import com.soaintCoopeuch.pruebaTecnicaFabian.domain.entities.Task;
import com.soaintCoopeuch.pruebaTecnicaFabian.infrastructure.exceptions.ModelNotFoundException;
import com.soaintCoopeuch.pruebaTecnicaFabian.infrastructure.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService{
    private ITaskRepository _taskRepository;

    @Autowired
    public TaskServiceImpl(ITaskRepository taskRepository) {
        this._taskRepository = taskRepository;
    }

    @Override
    public Task getById(Integer id)  throws Exception{
        Optional<Task> taskRepository = this._taskRepository.findById(id);
        return  taskRepository.isPresent() ? taskRepository.get() : null;
    }

    @Override
    public List<Task> getAll() throws Exception {
        return this._taskRepository.findAll();
    }

    @Override
    public Task add(Task task) throws Exception {
        return this._taskRepository.save(task);
    }

    @Override
    public void delete(Integer id) throws Exception {
        this._taskRepository.deleteById(id);
    }

    @Override
    public Task update(Task task) throws Exception {
        return this._taskRepository.save(task);
    }
}
