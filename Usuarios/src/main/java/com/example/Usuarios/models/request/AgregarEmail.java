package com.example.Usuarios.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarEmail {
    
    @NotBlank
    private int id_email;

    @NotBlank
    private String email;
}
