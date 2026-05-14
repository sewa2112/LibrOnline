package com.example.matriculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.matriculas.models.entities.Antecedentes_apoderados;
import com.example.matriculas.models.request.Actualizar_antecedentess_apo;
import com.example.matriculas.models.request.Agregar_antecedentess_apo;
import com.example.matriculas.repositories.AntecedentesApodRepository;

@Service
public class Antecedentes_apo_services {
    

    @Autowired
    private AntecedentesApodRepository antecedentesApodRepository;

    public List<Antecedentes_apoderados> obtenerTodasLosAntecedentes(){
        return antecedentesApodRepository.findAll();
    }

    public Antecedentes_apoderados obtenerAntecedentesPorId(int id_antecedentes){
        Antecedentes_apoderados antecedentes_apoderados = antecedentesApodRepository.findById(id_antecedentes).orElse(null);
        if (antecedentes_apoderados == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "antecedentes no encontrada");
        }
        return antecedentes_apoderados;

    }

    public Antecedentes_apoderados agregarAntecedentes(Agregar_antecedentess_apo nuevoAntecedente){
        Antecedentes_apoderados AntecedenteNuevo = new Antecedentes_apoderados();
        AntecedenteNuevo.setNivel_academico(nuevoAntecedente.getNivel_academico());
        AntecedenteNuevo.setNumero_hijos(nuevoAntecedente.getNumero_hijos());
        AntecedenteNuevo.setEstado_civil(nuevoAntecedente.getEstado_civil());
        return antecedentesApodRepository.save(AntecedenteNuevo);
    }

    public String eliminarAntecedentes(int id_antecedente){
        if (antecedentesApodRepository.existsById(id_antecedente)) { 
            antecedentesApodRepository.deleteById(id_antecedente);   
            return "antecedente Eliminada correctamente."; 
        }else{
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"antecedente no encontrada.");
        }
    }

    public Antecedentes_apoderados actualizAntecedente(Actualizar_antecedentess_apo actualizar_antecedentess_apo){
        Antecedentes_apoderados antecedentes_apoderados = antecedentesApodRepository.findById(actualizar_antecedentess_apo.getId_antecedentes_apo()).orElse(null);
        if(antecedentes_apoderados == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"antecedente no encontrada");
        }else{
        antecedentes_apoderados.setNivel_academico(actualizar_antecedentess_apo.getNivel_academico());
        antecedentes_apoderados.setNumero_hijos(actualizar_antecedentess_apo.getNumero_hijos());
        antecedentes_apoderados.setEstado_civil(actualizar_antecedentess_apo.getEstado_civil());
        return antecedentesApodRepository.save(antecedentes_apoderados);
        }
    }
}
