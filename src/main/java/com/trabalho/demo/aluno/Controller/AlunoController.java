package com.trabalho.demo.aluno.Controller;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.aluno.Service.AlunoService;
import com.trabalho.demo.disciplina.Model.Disciplina;
import com.trabalho.demo.disciplina.Service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    public AlunoService alunoService;
    @PostMapping()
    private ResponseEntity<Object> novoAluno(@RequestBody Aluno aluno) {
        System.out.println(aluno);
        if(aluno.getDisciplina().getId() == null) {
            return ResponseEntity.status(HttpStatus.OK).body(alunoService.novoAluno(aluno));
        }
        Optional<Disciplina> disc = alunoService.buscarIdDisciplina(aluno.getDisciplina().getId());
        if(disc.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(alunoService.novoAluno(aluno));
        }
        aluno.setDisciplina(disc.get());
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.novoAluno(aluno));
    }

    @GetMapping()
    private List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Object> listaAlunoPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.listarAlunoPorId(id));
    }

    @PutMapping("/{id}")
    private ResponseEntity<Object> atualizaAluno(@PathVariable Integer id,
                                                 @RequestBody Aluno aluno) {
        Optional<Aluno> alunoEncontrado = alunoService.listarAlunoPorId(id);

        if(alunoEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado");
        }

        Aluno pessoa = alunoEncontrado.get();

        pessoa.setDisciplina(aluno.getDisciplina());
        pessoa.setNome(aluno.getNome());
        pessoa.setCpf(aluno.getCpf());
        pessoa.setCidade(pessoa.getCidade());

        alunoService.novoAluno(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deletaUsuario(@PathVariable Integer id) {
        Optional<Aluno> alunoEncontrado = alunoService.listarAlunoPorId(id);

        if(alunoEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado");
        }
         alunoService.deletaUsuario(alunoEncontrado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Item deletado com sucesso!");
    }
}
