package com.example.Gestion_Reuniones.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "asistentes")
public class Asistente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id_asistente;

    @Column(nullable = false)
    private String primer_nombre;

    @Column(nullable = false)
    private String segundo_nombre;

    @Column(nullable = false)
    private String primer_apellido;

    @Column(nullable = false)
    private String segundo_apellido;
    
}

