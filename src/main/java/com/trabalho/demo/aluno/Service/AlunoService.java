package com.trabalho.demo.aluno.Service;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.aluno.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public List<Aluno> listarAlunos() {
        return repository.findAll();
    }
}
