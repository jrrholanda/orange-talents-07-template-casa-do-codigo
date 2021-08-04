package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.pais.Pais;

public class PaisResponse {

    private String nome;

    public PaisResponse(Pais pais) {
        this.nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }
}
