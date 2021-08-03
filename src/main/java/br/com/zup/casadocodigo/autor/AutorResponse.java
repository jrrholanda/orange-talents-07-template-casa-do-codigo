package br.com.zup.casadocodigo.autor;

import java.time.LocalDateTime;

public class AutorResponse {

    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime data;

    public AutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.data = autor.getCreateDate();
    }
}
