package br.com.zup.casadocodigo.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ExisteEstadoNoPais existeEstadoNoPais;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(existeEstadoNoPais);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteResponse> post (@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.toModel(manager);
        manager.persist(cliente);
        try {
            return ResponseEntity.ok().body(new ClienteResponse(cliente));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
