package com.example.Gestion_Cursos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarDocente {
    
    @NotBlank
    private int id_docente;

    @NotBlank
    private String nombre_docente;

    @NotBlank
    private String especialidad;
}
