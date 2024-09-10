package br.ufc.ControleLaboratorio.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.ControleLaboratorio.Model.Aluno;
import br.ufc.ControleLaboratorio.Repository.AlunoRepository;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    
    @Autowired
    AlunoRepository alunoRepository;
    
    @GetMapping
    public List<Aluno> GetAllAluno() {
        return (List<Aluno>) alunoRepository.findAll();
    }
    
    @PostMapping
    public Aluno save(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable("id") int id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()) {
            return ResponseEntity.ok(aluno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable("id") int id, @RequestBody Aluno alunoDetails) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setNome(alunoDetails.getNome());
            aluno.setEmail(alunoDetails.getEmail());
            aluno.setSenha(alunoDetails.getSenha());
            aluno.setMatricula(alunoDetails.getMatricula());
            alunoRepository.save(aluno);
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable("id") int id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
