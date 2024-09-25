package com.seb.practicap.repositories;

import com.seb.practicap.entities.Facultad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultadRepository extends JpaRepository<Facultad, Long> {
    List<Facultad> findFacultadByNombre(String nombre);
    Facultad findFaByNombre(String nombre);
}
