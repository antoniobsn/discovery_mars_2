package br.com.absn.controller.mapper;

import br.com.absn.controller.request.SondaRequest;
import br.com.absn.model.Sonda;
import br.com.absn.model.enums.Direcao;
import br.com.absn.model.tinytypes.Coordenadas;
import br.com.absn.service.SondaService;
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
public class SondaMapperTest {

    @InjectMocks
    private SondaMapper mapper;

    @Test
    public void converteRequestEmSonda() throws Exception {
        Coordenadas coordenadas = new Coordenadas(1,2);

        SondaRequest request = new SondaRequest(coordenadas, Direcao.N);
        Sonda sonda = new Sonda(coordenadas, Direcao.N);

        Assert.assertEquals(sonda, mapper.converteRequestEmSonda(request));
    }

}