package com.example.Usuarios.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarRol {
    
    @NotBlank
    private int id_rol;

    @NotBlank 
    private String tipo_rol;
}
