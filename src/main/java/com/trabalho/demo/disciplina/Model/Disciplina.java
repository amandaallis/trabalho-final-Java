package com.trabalho.demo.disciplina.Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    public String name;

    public Disciplina() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    @Column(name = "nota")
//    private Float nota;

//    @OneToMany
//    @JoinColumn(name = "id")
//    private Cursos cursos;

}
