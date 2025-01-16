package com.exemplo.buscalivros.service;

import com.exemplo.buscalivros.model.Livro;
import com.exemplo.buscalivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    private static final String GUTENDEX_API = "https://gutendex.com/books?search=";

    public Livro buscarLivroPorTitulo(String titulo) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(GUTENDEX_API + titulo))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Lógica de parse do JSON omitida para simplicidade

            // Exemplo de livro fictício para simulação
            Livro livro = new Livro();
            livro.setTitulo(titulo);
            livro.setAutor("Autor Exemplo");
            livro.setIdioma("en");
            livro.setAnoPublicacao(2020);

            livroRepository.save(livro);
            return livro;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar livro pela API", e);
        }
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public List<String> listarAutores() {
        return livroRepository.findAll().stream()
                .map(Livro::getAutor)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> listarAutoresPorAno(int ano) {
        return livroRepository.findAll().stream()
                .filter(livro -> livro.getAnoPublicacao() == ano)
                .map(Livro::getAutor)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Livro> listarLivrosPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }
}