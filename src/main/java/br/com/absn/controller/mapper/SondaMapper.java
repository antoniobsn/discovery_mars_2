package br.com.absn.controller.mapper;

import br.com.absn.controller.request.SondaRequest;
import br.com.absn.model.Sonda;
import org.springframework.stereotype.Component;

/**
 * Created by asampaio on 23/10/17.
 */

@Component
public class SondaMapper {

    public Sonda converteRequestEmSonda(SondaRequest request){
        return new Sonda(request.getCoordenadas(), request.getDirecao());
    }
}
