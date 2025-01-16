package com.exemplo.buscalivros.controller;

import com.exemplo.buscalivros.model.Livro;
import com.exemplo.buscalivros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/buscar")
    public Livro buscarLivroPorTitulo(@RequestParam String titulo) {
        return livroService.buscarLivroPorTitulo(titulo);
    }

    @GetMapping
    public List<Livro> listarLivrosRegistrados() {
        return livroService.listarLivros();
    }

    @GetMapping("/autores")
    public List<String> listarAutores() {
        return livroService.listarAutores();
    }

    @GetMapping("/autores/ano")
    public List<String> listarAutoresPorAno(@RequestParam int ano) {
        return livroService.listarAutoresPorAno(ano);
    }

    @GetMapping("/idiomas")
    public List<Livro> listarLivrosPorIdioma(@RequestParam String idioma) {
        return livroService.listarLivrosPorIdioma(idioma);
    }
}