package com.trabalho.demo.curso.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trabalho.demo.disciplina.Model.Disciplina;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
@Entity
@Table(name = "cursos")

public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne()
//    @JoinColumn(name = "disciplina")
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Disciplina disciplina;
    public Curso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Disciplina disciplina;
//    @ManyToOne()
//    @JoinColumn(name = "disciplina")
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JsonIgnoreProperties(value = "nome")
//    private Disciplina disciplina;

}
