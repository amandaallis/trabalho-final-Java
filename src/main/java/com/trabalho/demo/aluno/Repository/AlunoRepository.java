package com.trabalho.demo.aluno.Repository;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.disciplina.Model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    @Query("SELECT d FROM Aluno d WHERE d.id = :id")
     Aluno encontraPeloId(Integer id);
}
