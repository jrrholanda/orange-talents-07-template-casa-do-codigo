package br.com.zup.casadocodigo.autor;

import br.com.zup.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;
    @NotBlank @Email @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank @Size(max=400)
    private String descricao;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AutorRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max=400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel (){
        return new Autor(this.nome, this.email, this.descricao);
    }
}

