package com.example.Usuarios.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarRol {
    
    @NotBlank
    private int id_rol;

    @NotBlank 
    private String tipo_rol;
}
