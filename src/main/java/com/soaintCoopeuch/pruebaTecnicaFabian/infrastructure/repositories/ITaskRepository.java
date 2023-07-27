package com.soaintCoopeuch.pruebaTecnicaFabian.infrastructure.repositories;

import com.soaintCoopeuch.pruebaTecnicaFabian.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Integer> {
}
