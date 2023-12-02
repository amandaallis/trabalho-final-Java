package com.trabalho.demo.disciplina.Controller;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.disciplina.Model.Disciplina;
import com.trabalho.demo.disciplina.Service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;
    @PostMapping()
    public ResponseEntity<Object> novaDisciplina(@RequestBody Disciplina disciplina) {
        disciplinaService.novaDisciplina(disciplina);
        return ResponseEntity.status(HttpStatus.OK).body(disciplina);
    }

    @GetMapping()
    public List<Disciplina> listaDisciplinas() {
        return disciplinaService.listaDisciplina();
    }

    @GetMapping("/{id}")
    public Disciplina listaDisciplinaPorId(@PathVariable(value = "id") Integer id) {
        return disciplinaService.encontra(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizaDisciplina(@PathVariable(value = "id") Integer id,
                                                    @RequestBody Disciplina disciplina) {
        Optional<Disciplina> disciplinaEncontrada = disciplinaService.listaDisciplinaById(id);
        if(disciplinaEncontrada == null) {
            return ResponseEntity.status(HttpStatus.OK).body("Disciplina não encontrada");
        }
        Disciplina disciplina1 = disciplinaEncontrada.get();
        disciplina1.setName(disciplina.getName());
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.novaDisciplina(disciplina1));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deletarDisciplina(@PathVariable Integer id) {
        Optional<Disciplina> disciplinaEncontrada = disciplinaService.listaDisciplinaById(id);

        if(disciplinaEncontrada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado");
        }

        disciplinaService.deletaDisciplina(disciplinaEncontrada.get());
        return ResponseEntity.status(HttpStatus.OK).body("Item deletado com sucesso!");
    }
}
