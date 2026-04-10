package com.example.TaskFlow.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.example.TaskFlow.model.Tareas;

@Repository
public class TareasRepository {
    private List<Tareas> listaTareas = new ArrayList<>();

    public void guardar(Tareas e) {
        listaTareas.add(e);
    }

    public List<Tareas> listar() {
        return listaTareas;
    }

    public void eliminar(int id) {
        listaTareas.removeIf(e -> e.getId() == id);
    }

    public List<Tareas> buscarPorResponsable(String responsable) {
        
        List<Tareas> filtrados = new ArrayList<>();
        for (Tareas e : listaTareas) {
            if (e.getResponsable().equalsIgnoreCase(responsable)) {  
                filtrados.add(e);
            }
        }
       
        return filtrados;
    }

    public boolean actualizar(int id, Tareas nuevo) {
        for (int i = 0; i < listaTareas.size(); i++) { 
            if (listaTareas.get(i).getId() == id) {    
                listaTareas.set(i, nuevo);           
                return true;
            }
        }
        return false;
    }

} 
