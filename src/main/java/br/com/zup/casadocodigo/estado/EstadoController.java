package br.com.zup.casadocodigo.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private EstadoUnicoEmPais estadoUnicoEmPais;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoUnicoEmPais);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoResponse> post (@RequestBody @Valid EstadoRequest estadoRequest) {
        Estado estado = estadoRequest.toModel(manager);
        manager.persist(estado);
        try {
            return ResponseEntity.ok().body(new EstadoResponse(estado));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
