package com.trabalho.demo.aluno.Service;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.aluno.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public List<Aluno> listarAlunos() {
        return repository.findAll();
    }
    public Aluno novoAluno(Aluno aluno) {
        return repository.save(aluno);
    }
    public Optional<Aluno> listarAlunoPorId(Integer id) {
        return repository.findById(id);
    }
    public void deletaUsuario(Aluno aluno) {
         repository.delete(aluno);
    }
}
