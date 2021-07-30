package br.com.zup.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository repository;

    @Autowired
    private EmailUnicoValidator emailUnicoValidator;

    @InitBinder
    public void init (WebDataBinder binder){
        binder.addValidators(emailUnicoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorResponse> criaAutor (@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel();
        repository.save(autor);
        try {
            return ResponseEntity.ok().body(new AutorResponse(autor));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
