package com.example.matriculas.models.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Agregar_hoja_vida {
    
    @NotNull
    private LocalDate fecha_cracion;

    @NotBlank
    private int id_usuarios;
    
}