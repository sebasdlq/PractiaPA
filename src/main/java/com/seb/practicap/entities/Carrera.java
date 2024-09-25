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
@Table(name = "tbl_carreras")

public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_facultad", referencedColumnName = "id")
    private Facultad facultad;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrera")
    private List<Materia> materias = new ArrayList<>();
}
