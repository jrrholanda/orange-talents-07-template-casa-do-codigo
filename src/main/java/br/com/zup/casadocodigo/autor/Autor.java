package br.com.zup.casadocodigo.autor;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(max=400)
    private String descricao;
    @CreationTimestamp
    private LocalDateTime createDate;

    @Deprecated
    public Autor() {
    }

    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max=400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }
}
