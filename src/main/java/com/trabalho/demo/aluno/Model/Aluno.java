package com.trabalho.demo.aluno.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.demo.curso.Model.Curso;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "cidade")
    private String cidade;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cursos")
    private Curso cursos;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Curso getCursos() {
        return cursos;
    }

    public void setCursos(Curso cursos) {
        this.cursos = cursos;
    }

    public Aluno() {
    }
}
