package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.pais.PaisRequest;
import br.com.zup.casadocodigo.pais.PaisResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<Pais> getAll(){
        List<Pais> paises = manager.createQuery("select a from Pais a").getResultList();
        return paises;
    }

}
