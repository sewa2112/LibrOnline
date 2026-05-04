package com.example.Usuarios.models.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarEmail {
    
    @NotBlank
    private int id_email;

    @NotBlank
    private String email;
}
