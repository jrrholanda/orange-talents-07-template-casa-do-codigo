package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.autor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaResponse> criaAutor (@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();
        manager.persist(categoria);
        try {
            return ResponseEntity.ok().body(new CategoriaResponse(categoria));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
