package com.example.matriculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.matriculas.models.entities.Matriculas;
import com.example.matriculas.models.request.Actualizar_matricula;
import com.example.matriculas.models.request.Agregar_matricula;
import com.example.matriculas.repositories.MatriculasRepository;

@Service
public class MatriculaServices {
    
    @Autowired
    private MatriculasRepository matriculasRepository;

    public List<Matriculas> obtenerTodasLasMatriculas(){
        return matriculasRepository.findAll();
    }

    public Matriculas obtenerMatriculasPorId(int id_matriculas){
        Matriculas matriculas = matriculasRepository.findById(id_matriculas).orElse(null);
        if (matriculas == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "matricula no encontrada");
        }
        return matriculas;

    }

    public Matriculas agregarMatriculas(Agregar_matricula nuevoMatricula){
        Matriculas matriculaNuevo = new Matriculas();
        matriculaNuevo.setFecha_matricula(nuevoMatricula.getFecha_matricula());
        matriculaNuevo.setEstado_matricula(nuevoMatricula.getEstado_matricula());
        matriculaNuevo.setCoste_matricula(nuevoMatricula.getCoste_matricula());
        matriculaNuevo.setIva(nuevoMatricula.getIva());
        matriculaNuevo.setTotal_matriculas(nuevoMatricula.getTotal_matriculas());
        return matriculasRepository.save(matriculaNuevo);
    }

    public String eliminarMatriculas(int id_matricula){
        if (matriculasRepository.existsById(id_matricula)) { 
            matriculasRepository.deleteById(id_matricula);   
            return "matricula Eliminada correctamente."; 
        }else{
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Matricula no encontrada.");
        }
    }

    public Matriculas actualizMatriculas(Actualizar_matricula actualizar_matricula){
        Matriculas matriculas = matriculasRepository.findById(actualizar_matricula.getId_matriculas()).orElse(null);
        if(matriculas == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"matricula no encontrada");
        }else{
        matriculas.setFecha_matricula(actualizar_matricula.getFecha_matricula());
        matriculas.setEstado_matricula(actualizar_matricula.getEstado_matricula());
        matriculas.setCoste_matricula(actualizar_matricula.getCoste_matricula());
        matriculas.setIva(actualizar_matricula.getIva());
        matriculas.setTotal_matriculas(actualizar_matricula.getTotal_matriculas());
        return matriculasRepository.save(matriculas);
        }
    }

}


