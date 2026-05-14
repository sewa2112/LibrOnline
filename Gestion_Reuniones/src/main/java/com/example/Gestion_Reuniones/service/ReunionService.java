package com.example.Gestion_Reuniones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Gestion_Reuniones.models.entities.Reunion;
import com.example.Gestion_Reuniones.models.request.ActualizarReunion;
import com.example.Gestion_Reuniones.repository.ReunionRepository;

@Service
public class ReunionService {

    @Autowired
    private ReunionRepository reunionRepository;

    public List<Reunion> obtenerTodasLasReuniones() {
        return reunionRepository.findAll();
    }

    public Reunion obtenerReunionPorId(int id_reunion){
        Reunion reunion = reunionRepository.findById(id_reunion).orElse(null);
        if (reunion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reunión no encontrada con esa id: ");
        }
        return reunion;
    }


    public Reunion agregarReunion(Reunion nueva){
        Reunion reunionNueva = new Reunion();
        reunionNueva.setFecha(nueva.getFecha());
        reunionNueva.setHora_inicio(nueva.getHora_inicio());
        reunionNueva.setHora_fin(nueva.getHora_fin());
        reunionNueva.setAsunto(nueva.getAsunto());
        reunionNueva.setEstado(nueva.getEstado());
        return reunionRepository.save(reunionNueva);
    }
    

    public Reunion actualizarReunion(ActualizarReunion nuevaReunion){
        Reunion reunion = reunionRepository.findById(nuevaReunion.getId_reunion()).orElse(null);
        if (reunion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reunión no encontrada con esa id: ");
        }
        reunion.setFecha(nuevaReunion.getFecha());
        reunion.setHora_inicio(nuevaReunion.getHora_inicio());
        reunion.setHora_fin(nuevaReunion.getHora_fin());
        reunion.setAsunto(nuevaReunion.getAsunto());
        reunion.setEstado(nuevaReunion.getEstado());
        return reunionRepository.save(reunion);
    }

    public String eliminarReunion(int id_reunion){
        if (reunionRepository.existsById(id_reunion)) {
            reunionRepository.deleteById(id_reunion);
            return "Reunión eliminada correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reunión no encontrada con esa id: ");
        }
    }

}
