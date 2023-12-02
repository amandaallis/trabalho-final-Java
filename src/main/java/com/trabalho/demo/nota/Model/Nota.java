package com.trabalho.demo.nota.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.curso.Model.Curso;
import com.trabalho.demo.disciplina.Model.Disciplina;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "nota")
public class Nota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne()
//    @JoinColumn(name = "aluno_id")
    @Cascade(CascadeType.ALL)
    @JsonIgnoreProperties(value = "nome")
    private Aluno alunoId;

    @Column(name = "nota")
    private Float nota;

//    @ManyToOne()
////    @JoinColumn(name = "disciplina_id")
//    @Cascade(CascadeType.ALL)
//    private Disciplina disciplinaId;

    @ManyToOne()
    @JoinColumn(name = "disciplina")
    @Cascade(CascadeType.ALL)
    @JsonIgnoreProperties(value = "nome")
    private Disciplina disciplina;
    public Nota() {
    }

    public Aluno getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Aluno alunoId) {
        this.alunoId = alunoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
