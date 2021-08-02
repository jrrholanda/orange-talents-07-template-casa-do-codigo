package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String email);
}
