package com.example.TaskFlow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskFlow.repository.TareasRepository;
import com.example.TaskFlow.model.Tareas;

@Service
public class TareasService {

     
     @Autowired
     private TareasRepository tareasRepository;
 
     
     public void registrarTarea(Tareas e) {
         
        tareasRepository.guardar(e);
     }
 
     
     public List<Tareas> obtenerTodos() {
         return tareasRepository.listar();
     }
 
     
     public List<Tareas> filtrarPorResponsable(String responsable) {
        
         return tareasRepository.buscarPorResponsable(responsable);
     }
 
     
     public void borrarTarea(int id) {
        tareasRepository.eliminar(id);
     }
 
     
     public String actualizarTarea(int id, Tareas tareaNuevo) {
         boolean exito = tareasRepository.actualizar(id, tareaNuevo);
         if (exito) {
             return "tarea actualizada exitosamente";
         }
         return "tarea no encontrada";
     }
 
 
    
}
