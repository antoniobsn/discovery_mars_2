package br.com.absn.service;

import br.com.absn.model.Planalto;
import br.com.absn.model.Sonda;
import br.com.absn.model.enums.Direcao;
import br.com.absn.model.tinytypes.Coordenadas;
import br.com.absn.repository.PlanaltoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by asampaio on 23/10/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class PlanaltoServiceTest {

    @InjectMocks
    private PlanaltoService service;

    @Mock
    private PlanaltoRepository repositorio;

    @Mock
    private SondaService sondaService;


    @Test
    public void recebe() throws Exception {

        Coordenadas coordenadasPlanalto = new Coordenadas(5, 5);
        Coordenadas coordenadasSonda = new Coordenadas(1, 2);

        Planalto planalto = new Planalto(1L, coordenadasPlanalto);

        List<Sonda> sondas = new ArrayList<>();
        Sonda sondaParametro = new Sonda(coordenadasSonda, Direcao.N);
        Sonda sondaCriada = new Sonda(1L, coordenadasSonda, Direcao.N, planalto);
        sondas.add(sondaCriada);

        Planalto planaltoCompleto = new Planalto(1L, coordenadasPlanalto, sondas);

        Mockito.when(repositorio.buscaPorId(1L)).thenReturn(Optional.ofNullable(planalto));
        Mockito.when(sondaService.cria(sondaParametro, planalto)).thenReturn(sondaCriada);
        Mockito.when(repositorio.persiste(planaltoCompleto)).thenReturn(planaltoCompleto);

        Assert.assertEquals(planaltoCompleto, service.recebe(sondaParametro, 1L));
    }

    @Test
    public void buscaPorId() throws Exception {
        Coordenadas coordenadasPlanalto = new Coordenadas(5, 5);
        Coordenadas coordenadasSonda = new Coordenadas(1, 2);

        Planalto planalto = new Planalto(1L, coordenadasPlanalto);

        List<Sonda> sondas = new ArrayList<>();
        Sonda sondaCriada = new Sonda(1L, coordenadasSonda, Direcao.N, planalto);
        sondas.add(sondaCriada);

        Planalto planaltoCompleto = new Planalto(1L, coordenadasPlanalto, sondas);

        Mockito.when(repositorio.buscaPorId(1L)).thenReturn(Optional.ofNullable(planaltoCompleto));
        Assert.assertEquals(planaltoCompleto, service.buscaPorId(1L));
    }

}