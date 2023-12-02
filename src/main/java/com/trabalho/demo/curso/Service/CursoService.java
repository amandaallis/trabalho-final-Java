package com.trabalho.demo.curso.Service;

import com.trabalho.demo.aluno.Repository.AlunoRepository;
import com.trabalho.demo.curso.Model.Curso;
import com.trabalho.demo.curso.Repository.CursoRepository;
import com.trabalho.demo.disciplina.Model.Disciplina;
import com.trabalho.demo.disciplina.Repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Curso> encontraCursos() {
        return repository.findAll();
    }

    public Optional<Curso> encontraCursoPorId(Integer id) {
        return repository.findById(id);
    }

    public Optional<Disciplina> buscarIdDisciplina(Integer id) {
        return disciplinaRepository.findById(id);
    }
    public Curso novoCurso(Curso curso) {
        return repository.save(curso);
    }

    public void deletaCurso(Curso curso) {
         repository.delete(curso);
    }
}
