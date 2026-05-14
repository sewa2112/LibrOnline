package com.example.Gestion_Reuniones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Gestion_Reuniones.models.entities.Asistente;

public interface AsistenteRepository extends JpaRepository<Asistente, Integer> {
    
}
