package com.soaintCoopeuch.pruebaTecnicaFabian.application.services;

import com.soaintCoopeuch.pruebaTecnicaFabian.domain.entities.Task;

import java.util.List;

public interface ITaskService {
    Task getById(Integer id) throws Exception;
    List<Task> getAll() throws Exception;
    Task add(Task task) throws Exception;
    void delete(Integer id) throws Exception;

    Task update(Task task) throws Exception;
}
