package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.DetalheAutorResponse;

import java.time.LocalDate;

public class LivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private Float preco;
    private Integer qtdPaginas;
    private String isbn;
    private LocalDate data;
    private DetalheAutorResponse detalheAutor;


    public LivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.qtdPaginas = livro.getQtdPaginas();
        this.isbn = livro.getIsbn();
        this.data = livro.getData();
        this.detalheAutor = new DetalheAutorResponse(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Float getPreco() {
        return preco;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getData() {
        return data;
    }

    public DetalheAutorResponse getDetalheAutor() {
        return detalheAutor;
    }
}
