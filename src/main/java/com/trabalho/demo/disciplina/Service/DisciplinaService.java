package com.trabalho.demo.disciplina.Service;

import com.trabalho.demo.disciplina.Model.Disciplina;
import com.trabalho.demo.disciplina.Repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina novaDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listaDisciplina() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> listaDisciplinaById(Integer id) {
        return disciplinaRepository.findById(id);
    }

    public void deletaDisciplina(Disciplina disciplina) {
        disciplinaRepository.delete(disciplina);
    }

    public Disciplina encontra(Integer id) {
        return disciplinaRepository.encontraPeloId(id);
    }
}

