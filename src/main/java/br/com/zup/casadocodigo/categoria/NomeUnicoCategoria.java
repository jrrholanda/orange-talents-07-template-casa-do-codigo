package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.autor.AutorRepository;
import br.com.zup.casadocodigo.autor.AutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class NomeUnicoCategoria implements Validator {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        CategoriaRequest request = (CategoriaRequest) target;
        Optional<Categoria> categoria =  categoriaRepository.findByNome(request.getNome());

        if(categoria.isPresent()) {
            errors.rejectValue("nome", null, "Categoria já cadastrada");
        }
    }
}
