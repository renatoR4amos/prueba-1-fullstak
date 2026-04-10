package com.example.TaskFlow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.TaskFlow.model.Tareas;
import com.example.TaskFlow.service.TareasService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/tareas") //http://localhost:8080/tareas

public class TareasController {
    @Autowired
    private TareasService tareasService;

    
    @PostMapping("/registrar")
    public String registrar(@Valid @RequestBody Tareas e) {
        tareasService.registrarTarea(e);
        return "tarea registrada";
    }

   
    @GetMapping("/listar")
    public List<Tareas> listarTodo() {
        return tareasService.obtenerTodos();
    }

    
    @GetMapping("/buscar/{tipo}")
    public List<Tareas> buscar(@PathVariable String responsable) {
        return tareasService.filtrarPorResponsable(responsable);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        tareasService.borrarTarea(id);
        return "tarea eliminada";
    }
    
    @PutMapping("/actualizar/{id}")
    public String actualizar(@PathVariable int id, @Valid @RequestBody Tareas e) {
        return tareasService.actualizarTarea(id, e);
    }

}
