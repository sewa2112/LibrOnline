package com.example.direcciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.direcciones.models.entities.Ciudad;
import com.example.direcciones.models.request.ActualizarCiudad;
import com.example.direcciones.models.request.AgregarCiudad;
import com.example.direcciones.repositories.CiudadRepository;

@Service
public class CiudadServices {
    
    @Autowired
    private CiudadRepository ciudadRepository;

    public List<Ciudad> obtenerTodasLasCiudades(){
        return ciudadRepository.findAll();
    }

    public Ciudad obtenerCiudadPorId(int id_ciudad){
        Ciudad ciudad = ciudadRepository.findById(id_ciudad).orElse(null);
        if(ciudad == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ciudad no encontrada");
        }
        return ciudad;
    }

    public Ciudad agregarCiudad(AgregarCiudad nuevoCiudad){
        Ciudad ciudadNuevo = new Ciudad();
        ciudadNuevo.setNombre_ciudad(nuevoCiudad.getNombre_ciudad());
        return ciudadRepository.save(ciudadNuevo);
    }

    public String eliminarCiudad(int id_ciudad){
        if(ciudadRepository.existsById(id_ciudad)){
            ciudadRepository.deleteById(id_ciudad);
            return"ciudad eliminada correctamente. ";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ciudad no encontrada");
        }
    }

    public Ciudad actualizarCiudad(ActualizarCiudad actualizarCiudad){
        Ciudad ciudad = ciudadRepository.findById(actualizarCiudad.getId_ciudad()).orElse(null);
        if(ciudad == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ciudad no encontrada");
        }else{
            ciudad.setNombre_ciudad(actualizarCiudad.getNombre_ciudad());
            return ciudadRepository.save(ciudad);
        }
    }

}
