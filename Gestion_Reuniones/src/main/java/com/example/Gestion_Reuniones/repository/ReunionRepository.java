package com.example.Gestion_Reuniones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Gestion_Reuniones.models.entities.Reunion;

public interface ReunionRepository extends JpaRepository<Reunion, Integer> {
    
}
