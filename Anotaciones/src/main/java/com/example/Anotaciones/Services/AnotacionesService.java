package com.example.Anotaciones.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Anotaciones.Models.Entities.Anotaciones;
import com.example.Anotaciones.Repository.AnotacionesRepository;

@Service
public class AnotacionesService {

   @Autowired
    private AnotacionesRepository anotacionesRepository;

    public List<Anotaciones> obtenerTodas() {
        return anotacionesRepository.findAll();
    }

    public Anotaciones obtenerPorId(Integer id) {
        return anotacionesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Anotación no encontrada"));
    }

    public Anotaciones guardar(Anotaciones anotacion) {
        return anotacionesRepository.save(anotacion);
    }

    public String eliminar(Integer id) {

        if (anotacionesRepository.existsById(id)) {
            anotacionesRepository.deleteById(id);
            return "Anotación eliminada correctamente";
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Anotación no encontrada");
    }

    
}
