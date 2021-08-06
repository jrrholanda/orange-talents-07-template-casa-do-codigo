package br.com.zup.casadocodigo.cliente;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ExisteEstadoNoPais implements Validator {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        ClienteRequest clienteRequest = (ClienteRequest) target;

        Optional <Pais> pais = paisRepository.findById(clienteRequest.getIdPais());
        Pais paisObj = pais.get();

        if(paisObj.getEstados().isEmpty() && clienteRequest.getIdEstado() != null){
            errors.rejectValue("idEstado", null, "Erro");
        }
        if(!paisObj.getEstados().isEmpty()){
            boolean estadoValido = false;
            for(Estado estado: paisObj.getEstados()){
                if(estado.getId() == clienteRequest.getIdEstado()){
                    estadoValido = true;
                    break;
                }
            }
            if(estadoValido == false){
                errors.rejectValue("idEstado", null, "Erro");
            }
        }
    }
}
