package br.com.zup.casadocodigo.cliente;

public class ClienteResponse {

    private String email;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String complemento;
    private String cidade;
    private String pais;
    private String estado;
    private String telefone;
    private String cep;

    public ClienteResponse(Cliente cliente) {
        this.email = cliente.getEmail();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.endereco = cliente.getEndereco();
        this.complemento = cliente.getComplemento();
        this.cidade = cliente.getCidade();
        this.pais = cliente.getPais().getNome();
        this.telefone = cliente.getTelefone();
        this.cep = cliente.getCep();

        if(cliente.getEstado() != null){
            this.estado = cliente.getEstado().getNome();
        }
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

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
