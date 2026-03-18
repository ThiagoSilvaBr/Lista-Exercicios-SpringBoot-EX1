package com.bn.Exercicies.services;

import com.bn.Exercicies.models.LivroModel;
import com.bn.Exercicies.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> findall(){
        return livroRepository.findAll();
    }

    public Optional<LivroModel> findById(Long id){
        return livroRepository.findById(id);
    }

    public LivroModel criarLivro(LivroModel livroModel){
        return livroRepository.save(livroModel);
    }

    /*
    public LivroModel atualizarLivro(LivroModel livroModel, Long id){
       LivroModel livro = livroRepository.findById(id).get();
        livro.setTitulo(livroModel.getTitulo());

        return livroRepository.save(livro);

    }
    */

    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }
}