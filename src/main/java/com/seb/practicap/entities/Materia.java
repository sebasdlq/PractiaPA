package com.seb.practicap.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "tbl_materia")

public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String semestre;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "materias")
    private List<Estudiante> estudiantes = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_carrera", referencedColumnName = "id")
    private Carrera carrera;
}
