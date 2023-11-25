package com.trabalho.demo.aluno.Controller;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.aluno.Service.AlunoService;
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
        alunoService.novoAluno(aluno);
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
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

        pessoa.setCursos(aluno.getCursos());
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
