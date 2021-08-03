package br.com.zup.casadocodigo.categoria;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CategoriaResponse> post (@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();
        manager.persist(categoria);
        try {
            return ResponseEntity.ok().body(new CategoriaResponse(categoria));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
