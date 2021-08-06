package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;

import java.util.List;

public class PaisResponse {

    private String nome;
    private List <Estado> estados;

    public PaisResponse(Pais pais) {
        this.nome = pais.getNome();
        this.estados = pais.getEstados();
    }


    public String getNome() {
        return nome;
    }
}
