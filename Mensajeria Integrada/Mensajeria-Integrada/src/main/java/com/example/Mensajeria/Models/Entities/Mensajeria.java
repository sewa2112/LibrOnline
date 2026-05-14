package com.example.Mensajeria.Models.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensajeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;        // Ejemplo: "Reunión de Apoderados"
    private String descripcion;   // El cuerpo del mensaje
    private String destinatario;  // Ej: "Apoderados", "Alumnos" o "Todos"
    private LocalDateTime fechaEnvio;    // Usamos LocalDateTime para mayor precisión
    
}
