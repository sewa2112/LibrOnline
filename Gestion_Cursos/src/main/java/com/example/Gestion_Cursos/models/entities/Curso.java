package com.example.Gestion_Cursos.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_curso;

    @Column(nullable = false)
    private String letra;

    @Column(nullable = false)
    private String nivel_curso;

    @Column(nullable = false)
    private String id_sala;

    @Column(nullable = false)
    private String id_docente;


}
