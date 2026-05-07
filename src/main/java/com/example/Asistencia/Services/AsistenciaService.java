package com.example.Asistencia.Services;

import com.example.Asistencia.Models.Entities.Asistencia;
import com.example.Asistencia.Repository.AsistenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;


    public Asistencia guardarAsistencia(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }


    public List<Asistencia> obtenerTodas() {
        return asistenciaRepository.findAll();
    }

    public Optional<Asistencia> obtenerPorId(int id) {
        return asistenciaRepository.findById(id);
    }


    public Asistencia actualizarAsistencia(int id, Asistencia asistencia) {
        if (asistenciaRepository.existsById(id)) {
            asistencia.setId(id);
            return asistenciaRepository.save(asistencia);
        } else {
            throw new RuntimeException("Asistencia no encontrada con id: " + id);
        }
    }


    public void eliminarPorId(int id) {
        if (asistenciaRepository.existsById(id)) {
            asistenciaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Asistencia no encontrada con id: " + id);
        }
    }
}