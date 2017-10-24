package br.com.absn.controller.mapper;

import br.com.absn.controller.request.PlanaltoRequest;
import br.com.absn.model.Planalto;
import br.com.absn.model.tinytypes.Coordenadas;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by antonio on 24/10/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class PlanaltoMapperTest {

    @InjectMocks
    PlanaltoMapper mapper;

    @Test
    public void convertePlanaltoRequestEmPlanalto() throws Exception {

        Coordenadas coordenadas = new Coordenadas(5, 5);

        PlanaltoRequest planaltoRequest = new PlanaltoRequest(coordenadas);
        Planalto planalto = new Planalto(coordenadas);

        Assert.assertEquals(planalto, mapper.convertePlanaltoRequestEmPlanalto(planaltoRequest));
    }

}