package com.example.Asistencia.Controller;

import com.example.Asistencia.Models.Entities.Asistencia;
import com.example.Asistencia.Models.Request.CrearAsistenciaRequest;
import com.example.Asistencia.Models.Request.ActualizarAsistenciaRequest;
import com.example.Asistencia.Services.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    // Endpoint para obtener todas las asistencias (GET http://localhost:8080/api/asistencia)
    @GetMapping
    public List<Asistencia> obtenerTodas() {
        return asistenciaService.obtenerTodas();
    }

    // Endpoint para obtener una asistencia por ID (GET http://localhost:8080/api/asistencia/{id})
    @GetMapping("/{id}")
    public Optional<Asistencia> obtenerPorId(@PathVariable int id) {
        return asistenciaService.obtenerPorId(id);
    }

    // Endpoint para pasar la asistencia (POST http://localhost:8080/api/asistencia)
    @PostMapping
    public Asistencia guardar(@RequestBody CrearAsistenciaRequest request) {
        Asistencia asistencia = new Asistencia();
        asistencia.setEstudiante(request.getEstudiante());
        asistencia.setFecha(request.getFecha());
        asistencia.setEstado(request.getEstado());
        return asistenciaService.guardarAsistencia(asistencia);
    }

    // Endpoint para actualizar la asistencia (PUT http://localhost:8080/api/asistencia/{id})
    @PutMapping("/{id}")
    public Asistencia actualizar(@PathVariable int id, @RequestBody ActualizarAsistenciaRequest request) {
        Asistencia asistencia = new Asistencia();
        asistencia.setEstudiante(request.getEstudiante());
        asistencia.setFecha(request.getFecha());
        asistencia.setEstado(request.getEstado());
        return asistenciaService.actualizarAsistencia(id, asistencia);
    }

    // Endpoint para eliminar una asistencia (DELETE http://localhost:8080/api/asistencia/{id})
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        asistenciaService.eliminarPorId(id);
        return "Asistencia con id: " + id + " eliminada correctamente";
    }
}