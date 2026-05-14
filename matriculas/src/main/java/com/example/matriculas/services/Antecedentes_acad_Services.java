package com.example.matriculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.matriculas.models.entities.Antecedentes_academicos;
import com.example.matriculas.models.request.Actualizar_antecedentes_acad;
import com.example.matriculas.models.request.Agregar_antecedentes_acad;
import com.example.matriculas.repositories.AntecedentesAcadRepository;

@Service
public class Antecedentes_acad_Services {
     @Autowired
    private AntecedentesAcadRepository antecedentesAcademicosRepository;

    public List<Antecedentes_academicos> obtenerTodasLosAntecedentes(){
        return antecedentesAcademicosRepository.findAll();
    }

    public Antecedentes_academicos obtenerAntecedentesPorId(int id_antecedentes){
        Antecedentes_academicos antecedentes_academicos = antecedentesAcademicosRepository.findById(id_antecedentes).orElse(null);
        if (antecedentes_academicos == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "antecedentes no encontrada");
        }
        return antecedentes_academicos;

    }

    public Antecedentes_academicos agregarAntecedentes(Agregar_antecedentes_acad nuevoAntecedente){
        Antecedentes_academicos AntecedenteNuevo = new Antecedentes_academicos();
        AntecedenteNuevo.setLogros_academicos(nuevoAntecedente.getLogros_academicos());
        AntecedenteNuevo.setAnno_anterior(nuevoAntecedente.getAnno_anterior());
        AntecedenteNuevo.setProm_anno_anterior(nuevoAntecedente.getProm_anno_anterior());
        return antecedentesAcademicosRepository.save(AntecedenteNuevo);
    }

    public String eliminarAntecedente(int id_antecedente){
        if (antecedentesAcademicosRepository.existsById(id_antecedente)) { 
            antecedentesAcademicosRepository.deleteById(id_antecedente);   
            return "antecedente Eliminada correctamente."; 
        }else{
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"antecedente no encontrada.");
        }
    }

    public Antecedentes_academicos actualizAntecedente(Actualizar_antecedentes_acad actualizar_antecedentes_acad){
        Antecedentes_academicos antecedentes_academicos = antecedentesAcademicosRepository.findById(actualizar_antecedentes_acad.getId_antecedentes_academicos()).orElse(null);
        if(antecedentes_academicos == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"antecedente no encontrada");
        }else{
        antecedentes_academicos.setLogros_academicos(actualizar_antecedentes_acad.getLogros_academicos());
        antecedentes_academicos.setAnno_anterior(actualizar_antecedentes_acad.getAnno_anterior());
        antecedentes_academicos.setProm_anno_anterior(actualizar_antecedentes_acad.getProm_anno_anterior());
        return antecedentesAcademicosRepository.save(antecedentes_academicos);
        }
    }
}
