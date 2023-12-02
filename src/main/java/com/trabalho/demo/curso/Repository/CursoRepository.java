package com.trabalho.demo.curso.Repository;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.curso.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
