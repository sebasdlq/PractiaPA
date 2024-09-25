package com.seb.practicap.tests;

import com.seb.practicap.entities.Carrera;
import com.seb.practicap.entities.Facultad;
import com.seb.practicap.repositories.CarreraRepository;
import com.seb.practicap.repositories.EstudianteRepository;
import com.seb.practicap.repositories.FacultadRepository;
import com.seb.practicap.repositories.MateriaRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

public class BidirectionalTests {
    @Autowired
    CarreraRepository carreraRepository;
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    FacultadRepository facultadRepository;
    @Autowired
    MateriaRepository materiaRepository;

    @Test
    void saveFacultadSinCarreras(){
        Facultad facultad = new Facultad();
        facultad.setNombre("Facultad-SinCarreras");
        facultadRepository.save(facultad);
    }

    @Test
    void saveFacultadConCarreras(){
        Facultad facultad = new Facultad();
        facultad.setNombre("Facultad-ConCarreras");

        Carrera carrera1 = new Carrera();
        Carrera carrera2 = new Carrera();
        carrera1.setNombre("Carrera-1");
        carrera2.setNombre("Carrera-2");

        facultad.getCarreras().add(carrera1);
        facultad.getCarreras().add(carrera2);
        carrera1.setFacultad(facultad);
        carrera2.setFacultad(facultad);
        facultadRepository.save(facultad);
    }

    @Test
    void updateNameFacultad(){
        Facultad facultad = facultadRepository.findById(1L).get();
        facultad.setNombre("Facultad-Sincera");
        facultadRepository.save(facultad);
    }

    @Test
    void saveNewCarreraToExistingFacultad(){
        Carrera carrera = new Carrera();
        carrera.setNombre("Carrera B");

        Facultad facultad = facultadRepository.findById(1L).get();
        facultad.getCarreras().add(carrera);

        carrera.setFacultad(facultad);

        facultadRepository.save(facultad);
    }
    @Test
    void searchFacultad(){
        List<Facultad> facultades = facultadRepository.findFacultadByNombre("Facultad-Sincera");
        if(facultades.size() > 0){
            Facultad facultad = facultades.get(0);
            facultad.setNombre("Facultad Buscada");
            facultadRepository.save(facultad);
        }

    }
    @Test
    void deleteFacultad(){
        Facultad facultad = facultadRepository.findById(1L).get();
        facultadRepository.delete(facultad);
    }
    @Test
    void deleteCarrera(){
        Carrera carrera = carreraRepository.findById(17L).get();
//        carreraRepository.delete(carrera);

        carrera.setFacultad(null);
        carreraRepository.save(carrera);
        carreraRepository.delete(carrera); 
    }
}
