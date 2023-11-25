package com.trabalho.demo.disciplinas.Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "nota")
    private Float nota;

//    @OneToMany
//    @JoinColumn(name = "id")
//    private Cursos cursos;

}
