package com.trabalho.demo.cursos.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.demo.disciplinas.Model.Disciplina;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
@Entity
@Table(name = "cursos")

public class Cursos implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Disciplina disciplina;

}
