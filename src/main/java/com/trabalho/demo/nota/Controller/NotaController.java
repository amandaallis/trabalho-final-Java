package com.trabalho.demo.nota.Controller;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.aluno.Service.AlunoService;
import com.trabalho.demo.disciplina.Model.Disciplina;
import com.trabalho.demo.disciplina.Service.DisciplinaService;
import com.trabalho.demo.nota.Model.Nota;
import com.trabalho.demo.nota.Service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nota")
public class NotaController {
    @Autowired
    private NotaService notaService;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping()
    private List<Nota> listaNotas() {
        return notaService.listaNotas();
    }

    @PostMapping()
    private ResponseEntity<Object> novaNota(@RequestBody Nota nota) {
        if (nota.getNota() < 0.0 || nota.getNota() > 10.0) {
            return ResponseEntity.status(HttpStatus.OK).body("Nota inválida");
        }
        if (nota.getDisciplina() != null && nota.getDisciplina().getId() != null && nota.getAlunoId() != null) {
            Disciplina disciplina = disciplinaService.encontra(nota.getDisciplina().getId());
            Aluno aluno = alunoService.encontra(nota.getDisciplina().getId());
            if (disciplina == null) {
                return ResponseEntity.status(HttpStatus.OK).body("Disciplina não encontrada.");
            }
            if (aluno == null) {
                return ResponseEntity.status(HttpStatus.OK).body("Aluno não encontrado");
            }
            nota.setDisciplina(disciplina);
            nota.setAlunoId(aluno);
        }
            Nota notasalva = notaService.novaNota(nota);

            return ResponseEntity.status(HttpStatus.OK).body(notasalva);
}
    @GetMapping("/{id}")
    private  ResponseEntity<Object> listaNotasPorAluno(@PathVariable(value = "id") Integer id) {

        Optional<Nota> nota = notaService.notaId(id);
        if(nota.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado");
        }
        if(nota.get().getNota() >= 7) {
            return ResponseEntity.status(HttpStatus.OK).body("aprovado");
        }
        return ResponseEntity.status(HttpStatus.OK).body("reprovado");
    }

    @PutMapping("/{id}")
    private ResponseEntity<Object> atualizaNota(@PathVariable(value = "id") Integer id,
                              @RequestBody Nota nota) {
        Optional<Nota> notaencontrada = notaService.notaId(id);
        if(notaencontrada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado");
        }

        Nota nota1 = notaencontrada.get();
        nota1.setDisciplina(nota.getDisciplina());
        nota1.setAlunoId(nota.getAlunoId());
        notaService.novaNota(nota1);
        return ResponseEntity.status(HttpStatus.OK).body(nota1);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deletaNota(@PathVariable Integer id) {
        Optional<Nota> encontraNota = notaService.notaId(id);

        if(encontraNota.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado");
        }
        notaService.deletaNota(encontraNota.get());
        return ResponseEntity.status(HttpStatus.OK).body("Item deletado com sucesso!");
    }
}