package br.com.zup.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorResponse> criaAutor (@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel();
        manager.persist(autor);
        try {
            return ResponseEntity.ok().body(new AutorResponse(autor));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
