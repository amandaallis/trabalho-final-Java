package com.trabalho.demo.curso.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.demo.disciplina.Model.Disciplina;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "cursos")

public class Curso implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Disciplina disciplina;

}
