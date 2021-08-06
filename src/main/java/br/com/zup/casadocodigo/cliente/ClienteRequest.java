package br.com.zup.casadocodigo.cliente;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.validacao.CPFOrCNPJ;
import br.com.zup.casadocodigo.validacao.ExistsId;
import br.com.zup.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    @CPFOrCNPJ
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;
    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ClienteRequest(@NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
                          @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long idPais,
                          @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente toModel(EntityManager manager){
        Pais pais = manager.find(Pais.class, this.idPais);
        Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento, this.cidade, pais, this.telefone, this.cep);

        if(this.idEstado != null){
            Estado estado = manager.find(Estado.class, this.idEstado);
            cliente.setEstado(estado);
        }
        return cliente;
    }
}
