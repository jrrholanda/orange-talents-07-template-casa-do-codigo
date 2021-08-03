package br.com.zup.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class ListaLivrosResponse {

    private Long id;
    private String titulo;

    public ListaLivrosResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<ListaLivrosResponse> converter(List<Livro> livros) {
        return livros.stream().map(ListaLivrosResponse::new).collect(Collectors.toList());
    }
}
