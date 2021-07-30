package br.com.zup.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailUnicoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        AutorRequest request = (AutorRequest) target;
        Optional<Autor> autor =  autorRepository.findByEmail(request.getEmail());

        if(autor.isPresent()) {
            errors.rejectValue("email", null, "Email já cadastrado");
        }
    }
}
