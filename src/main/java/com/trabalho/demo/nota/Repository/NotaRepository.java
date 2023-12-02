package com.trabalho.demo.nota.Repository;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.nota.Model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {
    @Query("SELECT n FROM Nota n where n.id = id")
    Optional<Nota> findAllById(Integer id);
}
