package com.trabalho.demo.disciplina.Repository;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.disciplina.Model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

    @Query("SELECT d FROM Disciplina d WHERE d.id = :id")
    Disciplina encontraPeloId(Integer id);
}
