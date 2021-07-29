package br.com.zup.casadocodigo.autor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AutorResponse {

    private String nome;
    private String email;
    private String descricao;
    private Date data;

    public AutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.data = autor.getCreateDate();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {

        return email;
    }

    public String getDescricao() {

        return descricao;
    }

    public Date getData() {
        return data;
    }

}
