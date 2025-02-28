package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.categoria.Categoria;
import br.com.zup.casadocodigo.validacao.ExistsId;
import br.com.zup.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank @UniqueValue(fieldName = "titulo", domainClass = Livro.class)
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private Float preco;
    @NotNull @Min(100)
    private Integer qtdPaginas;
    @NotBlank @UniqueValue(fieldName = "isbn", domainClass = Livro.class)
    private String isbn;
    @Future @NotNull @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate data;
    @NotNull @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;
    @NotNull @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public LivroRequest(String titulo, String resumo, String sumario, Float preco, Integer qtdPaginas, String isbn, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.qtdPaginas = qtdPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toModel(EntityManager manager) {
        Autor autor = manager.find(Autor.class, this.idAutor);
        Categoria categoria = manager.find(Categoria.class, this.idCategoria);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.qtdPaginas,
                this.isbn, this.data, categoria, autor);
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
