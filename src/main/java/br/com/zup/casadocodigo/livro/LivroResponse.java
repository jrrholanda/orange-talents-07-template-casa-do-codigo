package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.categoria.Categoria;

import java.time.LocalDate;

public class LivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private Float preco;
    private Integer qtdPaginas;
    private String isbn;
    private LocalDate data;
    private Categoria categoria;
    private Autor autor;

    public LivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.qtdPaginas = livro.getQtdPaginas();
        this.isbn = livro.getIsbn();
        this.data = livro.getData();
        this.categoria = livro.getCategoria();
        this.autor = livro.getAutor();
    }
}
