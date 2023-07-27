package com.soaintCoopeuch.pruebaTecnicaFabian.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {
    private Integer id;

    @NotNull(message = "descripción no debe ser nulo")
    @NotBlank(message = "descripción no debe estar vacio")
    private String description;

    @NotNull(message = "fecha creación no debe ser nulo")
    private LocalDateTime createdAt;

    @NotNull(message = "vigencia no debe ser nulo")
    private boolean activated;
}
