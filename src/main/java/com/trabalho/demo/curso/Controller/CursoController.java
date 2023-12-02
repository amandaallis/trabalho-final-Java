package com.trabalho.demo.curso.Controller;
import com.trabalho.demo.curso.Model.Curso;
import com.trabalho.demo.curso.Service.CursoService;
import com.trabalho.demo.disciplina.Model.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    public CursoService cursoService;
    @PostMapping()
    public ResponseEntity<Object> novoCurso(@RequestBody Curso curso) {
        if(curso.getDisciplina().getId() == null) {
            return ResponseEntity.status(HttpStatus.OK).body(cursoService.novoCurso(curso));
        }
        Optional<Disciplina> disc = cursoService.buscarIdDisciplina(curso.getDisciplina().getId());
        if(disc.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(cursoService.novoCurso(curso));
        }
        curso.setDisciplina(disc.get());
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.novoCurso(curso));
//        cursoService.novoCurso(curso);
//       return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

    @GetMapping()
    public List<Curso> listaCursos() {
        return cursoService.encontraCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> pegaCursoPorId(@PathVariable(value = "id") Integer id) {
        Optional<Curso> curso = cursoService.encontraCursoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizaCurso(@PathVariable(value = "id") Integer id,
                                                         @RequestBody Curso curso) {
        Optional<Curso> cursoEncontrado = cursoService.encontraCursoPorId(id);

        if(cursoEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado");
        }
        Curso curso1 = cursoEncontrado.get();

        curso1.setNome(curso.getNome());
        if(cursoEncontrado.get().getDisciplina().getId() == curso.getDisciplina().getId()) {
            curso1.setDisciplina(cursoEncontrado.get().getDisciplina());
        }
        else {
            curso1.setDisciplina(curso.getDisciplina());
        }
        cursoService.novoCurso(curso1);
        return ResponseEntity.status(HttpStatus.OK).body(curso1);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Object>  deletaCurso(@PathVariable(value = "id") Integer id) {
        Optional<Curso> cursoEncontrado = cursoService.encontraCursoPorId(id);

        if(cursoEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado");
        }
        cursoService.deletaCurso(cursoEncontrado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Item deletado com sucesso.");
    }
}
