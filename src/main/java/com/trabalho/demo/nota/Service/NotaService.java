package com.trabalho.demo.nota.Service;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.aluno.Repository.AlunoRepository;
import com.trabalho.demo.nota.Model.Nota;
import com.trabalho.demo.nota.Repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    @Autowired
    private NotaRepository repository;
    private AlunoRepository alunoRepository;

    public Nota novaNota(Nota nota) {
        return repository.save(nota);
    }

    public List<Nota> listaNotas() {
        return repository.findAll();
    }

    public Optional<Nota> notaId(Integer id) {
        return repository.findById(id);
    }
    public void deletaNota(Nota nota) {
         repository.delete(nota);
    }
}
