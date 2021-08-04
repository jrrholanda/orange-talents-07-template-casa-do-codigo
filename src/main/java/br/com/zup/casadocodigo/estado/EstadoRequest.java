package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.validacao.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    private String nome;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public EstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, this.idPais);
        return new Estado(this.nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
