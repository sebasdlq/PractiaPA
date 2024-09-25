package com.seb.practicap.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "tbl_estudiantes")

public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbl_estudiantes_materias",
            joinColumns = @JoinColumn(name = "id_estudiante", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_materia", referencedColumnName = "id")
    )
    private List<Materia> materias = new ArrayList<>();
}
