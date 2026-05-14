package com.example.matriculas.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "antecedentes_academicos")
public class Antecedentes_academicos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_antecedentes_academicos;

    private String logros_academicos;

    @Column(nullable = false)
    private LocalDate anno_anterior;

    private Float prom_anno_anterior;
}