package br.com.absn.controller;

import br.com.absn.controller.mapper.PlanaltoMapper;
import br.com.absn.controller.mapper.SondaMapper;
import br.com.absn.controller.request.PlanaltoRequest;
import br.com.absn.controller.request.SondaRequest;
import br.com.absn.model.Planalto;
import br.com.absn.model.Sonda;
import br.com.absn.model.enums.Direcao;
import br.com.absn.model.tinytypes.Coordenadas;
import br.com.absn.repository.PlanaltoRepository;
import br.com.absn.service.PlanaltoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by asampaio on 23/10/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class PlanaltoControllerTest {

    @InjectMocks
    private PlanaltoController controller;

    @Mock
    private PlanaltoRepository repositorio;

    @Mock
    private PlanaltoMapper mapper;

    @Mock
    private PlanaltoService service;

    @Mock
    private SondaMapper sondaMapper;

    @Test
    public void cria() throws Exception {
        Coordenadas coordenadas = new Coordenadas(5, 5);

        Planalto planaltoParametro = new Planalto(coordenadas);
        Planalto planaltoCriado = new Planalto(1L, coordenadas);
        PlanaltoRequest planaltoRequest = new PlanaltoRequest(coordenadas);

        Mockito.when(mapper.convertePlanaltoRequestEmPlanalto(planaltoRequest)).thenReturn(planaltoParametro);

        Mockito.when(repositorio.cria(planaltoParametro)).thenReturn(planaltoCriado);

        Assert.assertEquals(planaltoCriado ,controller.cria(planaltoRequest));
    }

    @Test
    public void recebe() throws Exception {

        Coordenadas coordenadasPlanalto = new Coordenadas(5, 5);
        Coordenadas coordenadasSonda = new Coordenadas(1, 2);

        SondaRequest sondaRequest = new SondaRequest(coordenadasSonda, Direcao.N);
        Sonda sondaParametro = new Sonda(coordenadasSonda, Direcao.N);

        Planalto planalto = new Planalto(1L, coordenadasPlanalto);

        List<Sonda> sondas = new ArrayList<>();
        Sonda sonda = new Sonda(1L, coordenadasSonda, Direcao.N, planalto);
        sondas.add(sonda);

        Planalto planaltoRetorno = new Planalto(1L, coordenadasPlanalto, sondas);

        Mockito.when(sondaMapper.converteRequestEmSonda(sondaRequest)).thenReturn(sondaParametro);

        Mockito.when(service.recebe(sondaParametro, 1L)).thenReturn(planaltoRetorno);

        Assert.assertEquals(planaltoRetorno, controller.recebe(1L, sondaRequest));
    }

    @Test
    public void buscaPorId() throws Exception {

        Coordenadas coordenadasPlanalto = new Coordenadas(5, 5);
        Coordenadas coordenadasSonda = new Coordenadas(1, 2);

        Planalto planalto = new Planalto(1L, coordenadasPlanalto);

        List<Sonda> sondas = new ArrayList<>();
        Sonda sonda = new Sonda(1L, coordenadasSonda, Direcao.N, planalto);
        sondas.add(sonda);

        Mockito.when(service.buscaPorId(1L)).thenReturn(new Planalto(1L, coordenadasPlanalto, sondas));

        controller.buscaPorId(1L);
    }

}