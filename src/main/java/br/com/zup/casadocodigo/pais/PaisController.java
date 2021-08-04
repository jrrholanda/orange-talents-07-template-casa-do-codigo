package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.pais.PaisRequest;
import br.com.zup.casadocodigo.pais.PaisResponse;
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
@RequestMapping("/pais")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<PaisResponse> post (@RequestBody @Valid PaisRequest paisRequest) {
        Pais pais = paisRequest.toModel();
        manager.persist(pais);
        try {
            return ResponseEntity.ok().body(new PaisResponse(pais));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
