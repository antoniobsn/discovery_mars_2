package br.com.absn.controller.mapper;

import br.com.absn.controller.request.PlanaltoRequest;
import br.com.absn.model.Planalto;
import org.springframework.stereotype.Component;

/**
 * Created by asampaio on 23/10/17.
 */
@Component
public class PlanaltoMapper {

    public Planalto convertePlanaltoRequestEmPlanalto(PlanaltoRequest request){
        return new Planalto(request.getCoordenadas());
    }
}
