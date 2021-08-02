package br.com.zup.casadocodigo.categoria;

public class CategoriaResponse {

    private String nome;

    public CategoriaResponse(Categoria categoria) {
        this.nome = categoria.getNome();
    }
}
