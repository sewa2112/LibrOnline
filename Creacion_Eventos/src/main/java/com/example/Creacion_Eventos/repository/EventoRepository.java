package com.example.Creacion_Eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Creacion_Eventos.models.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
    
}
