package com.soaintCoopeuch.pruebaTecnicaFabian.infrastructure.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private LocalDateTime date;
    private String message;
    private String details;
}
