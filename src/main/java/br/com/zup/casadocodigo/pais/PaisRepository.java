package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.pais.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {

}
