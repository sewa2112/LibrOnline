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

    public List<Asistencia> obtenerTodas() {
        return asistenciaRepository.findAll();
    }

    public Optional<Asistencia> obtenerPorId(int id) {
        return asistenciaRepository.findById(id);
    }

    public Asistencia guardarAsistencia(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    public Asistencia actualizarAsistencia(int id, Asistencia asistencia) {
        Optional<Asistencia> asistenciaExistente = asistenciaRepository.findById(id);
        if (asistenciaExistente.isEmpty()) {
            throw new RuntimeException("Asistencia con id " + id + " no encontrada");
        }
        Asistencia actual = asistenciaExistente.get();
        actual.setEstudiante(asistencia.getEstudiante());
        actual.setFecha(asistencia.getFecha());
        actual.setEstado(asistencia.getEstado());
        return asistenciaRepository.save(actual);
    }

    public void eliminarPorId(int id) {
        asistenciaRepository.deleteById(id);
    }
}
