package br.com.zup.casadocodigo.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EstadoUnicoEmPais implements Validator {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return EstadoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        EstadoRequest estadoRequest = (EstadoRequest) target;
        Optional<Estado> estado = estadoRepository.findByNome(estadoRequest.getNome());

        if(estado.isPresent() && estado.get().getPais().getId() == estadoRequest.getIdPais()){
            errors.rejectValue("nome", null, "Já existe um estado com esse nome no páis informado");
        }
    }
}
