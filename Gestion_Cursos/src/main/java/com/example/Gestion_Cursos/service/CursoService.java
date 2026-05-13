package com.example.Gestion_Cursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Gestion_Cursos.models.entities.Curso;
import com.example.Gestion_Cursos.models.request.ActualizarCurso;
import com.example.Gestion_Cursos.models.request.AgregarCurso;
import com.example.Gestion_Cursos.repository.CursoRepository;

@Service
public class CursoService {
    

    @Autowired
    private CursoRepository cursoRepository;

    public List <Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerCursoPorId(int id_curso) {
        Curso curso = cursoRepository.findById(id_curso).orElse(null);
        if (curso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado con esa id");
        }
        return curso;
    }

    public Curso agregarCurso(AgregarCurso nuevo){
        Curso cursoNuevo = new Curso();
        cursoNuevo.setLetra(nuevo.getLetra());
        cursoNuevo.setNivel_curso(nuevo.getNivel_curso());
        cursoNuevo.setId_sala(nuevo.getId_sala());
        cursoNuevo.setId_docente(nuevo.getId_docente());
        return cursoRepository.save(cursoNuevo);
    }

    public String eliminarCurso(int id_curso) {
        if (cursoRepository.existsById(id_curso)) {
            cursoRepository.deleteById(id_curso);
            return "Curso eliminado correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado con esa id");
        }
    }

    public Curso actualizaCurso(ActualizarCurso nuevoCurso) {
        Curso curso = cursoRepository.findById(nuevoCurso.getId_curso()).orElse(null);
        if (curso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado con esa id");
        }
        curso.setLetra(nuevoCurso.getLetra());
        curso.setNivel_curso(nuevoCurso.getNivel_curso());
        curso.setId_sala(nuevoCurso.getId_sala());
        curso.setId_docente(nuevoCurso.getId_docente());
        return cursoRepository.save(curso); 

    }
}
