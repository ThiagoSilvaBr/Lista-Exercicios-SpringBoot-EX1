package com.bn.Exercicies.controllers;

import com.bn.Exercicies.models.LivroModel;
import com.bn.Exercicies.services.LivroService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;


    @PostMapping
    public ResponseEntity<LivroModel> addLivro(@RequestBody LivroModel livroModel){
        LivroModel request =  livroService.criarLivro(livroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(request.getId()).toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> procurarTodosLivros(){
        List<LivroModel> request = livroService.findall();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LivroModel>> procurarPorId(@PathVariable Long id){
        Optional<LivroModel> request = livroService.findById(id);
        return ResponseEntity.ok().body(request);
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> atualizarLivro(@PathVariable Long id, @RequestBody LivroModel livroModel){
        LivroModel request = livroService.atualizarLivro(id, livroModel);
        return ResponseEntity.status(201).body(livroModel);
    }
    */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

}