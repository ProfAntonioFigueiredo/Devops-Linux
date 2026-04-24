package br.fiap.portal.controller;

import br.fiap.portal.model.TAluno;
import br.fiap.portal.repository.TAlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class TAlunoController {
    private final TAlunoRepository repository;

    public TAlunoController(TAlunoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TAluno> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{rmAluno}")
    public ResponseEntity<TAluno> getById(@PathVariable String rmAluno) {
        Optional<TAluno> aluno = repository.findById(rmAluno);
        return aluno.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TAluno> create(@RequestBody TAluno aluno) {
        TAluno savedAluno = repository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAluno);
    }

    @PutMapping("/{rmAluno}")
    public ResponseEntity<TAluno> update(@PathVariable String rmAluno, @RequestBody TAluno aluno) {
        if (!repository.existsById(rmAluno)) {
            return ResponseEntity.notFound().build();
        }
        aluno.setRmAluno(rmAluno);
        return ResponseEntity.ok(repository.save(aluno));
    }

    @DeleteMapping("/{rmAluno}")
    public ResponseEntity<Void> delete(@PathVariable String rmAluno) {
        if (!repository.existsById(rmAluno)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(rmAluno);
        return ResponseEntity.noContent().build();
    }
}
