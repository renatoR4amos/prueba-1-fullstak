package com.example.TaskFlow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tareas {
    private int id;

    @NotBlank(message = "La descricion no puede estar vacia") 
    private String descripcion;

    @NotBlank(message = "el estado es obligatorio.")
    private String estadoTarea;

    @Min(value = 1, message = "la prioridad no puede sser menor a 1") 
    @Max(value = 10, message = "la prioridad no puede superar 10")
    private int prioridad;

    @NotBlank(message = "es obligatorio el nombre del trabador a cargo")
    private String responsable;

    @NotBlank(message = "fecha de inicio como minimo requerimiento")
    private String fechas;

} 