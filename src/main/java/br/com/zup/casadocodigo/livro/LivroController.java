package br.com.zup.casadocodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroResponse> post (@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(manager);
        manager.persist(livro);
        try {
            return ResponseEntity.ok().body(new LivroResponse(livro));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
