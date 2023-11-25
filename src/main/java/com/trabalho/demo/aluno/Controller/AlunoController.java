package com.trabalho.demo.aluno.Controller;

import com.trabalho.demo.aluno.Model.Aluno;
import com.trabalho.demo.aluno.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    public AlunoService alunoService;
    @PostMapping()
    private ResponseEntity<Object> novoAluno(@RequestBody Aluno aluno) {

        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }

    @GetMapping()
    private List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }

}
