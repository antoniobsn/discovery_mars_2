package br.com.absn.service;

import br.com.absn.model.Planalto;
import br.com.absn.model.Sonda;
import br.com.absn.model.enums.Comando;
import br.com.absn.model.enums.Direcao;
import br.com.absn.model.tinytypes.Comandos;
import br.com.absn.model.tinytypes.Coordenadas;
import br.com.absn.repository.SondaRepository;
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

import static org.junit.Assert.*;

/**
 * Created by antonio on 24/10/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class SondaServiceTest {

    @InjectMocks
    private SondaService service;

    @Mock
    private SondaRepository repositorio;

    @Test
    public void cria() throws Exception {

        Coordenadas coordenadasPlanalto = new Coordenadas(5, 5);
        Coordenadas coordenadasSonda = new Coordenadas(1, 2);

        Sonda sondaParametro = new Sonda(coordenadasSonda, Direcao.N);

        Planalto planalto = new Planalto(1L, coordenadasPlanalto);

        List<Sonda> sondas = new ArrayList<>();
        Sonda sondaCompleta = new Sonda(1L, coordenadasSonda, Direcao.N, planalto);
        sondas.add(sondaCompleta);

        Planalto planaltoCompleto = new Planalto(1L, coordenadasPlanalto, sondas);

        Mockito.when(repositorio.cria(sondaParametro, planaltoCompleto)).thenReturn(sondaCompleta);

        Assert.assertEquals(sondaCompleta,service.cria(sondaParametro, planaltoCompleto));
    }

    @Test
    public void explora() throws Exception {
        Coordenadas coordenadasPlanalto = new Coordenadas(5, 5);
        Coordenadas coordenadasSonda = new Coordenadas(1, 2);
        Coordenadas coordenadasSondaRetorno = new Coordenadas(1, 3);

        Planalto planalto = new Planalto(1L, coordenadasPlanalto);

        Sonda sondaCompleta = new Sonda(1L, coordenadasSonda, Direcao.N, planalto);
        Sonda sondaRetorno = new Sonda(1L, coordenadasSondaRetorno, Direcao.N, planalto);

        List<Comando> comandoList = new ArrayList<>();
        comandoList.add(Comando.L);
        comandoList.add(Comando.M);
        comandoList.add(Comando.L);
        comandoList.add(Comando.M);
        comandoList.add(Comando.L);
        comandoList.add(Comando.M);
        comandoList.add(Comando.L);
        comandoList.add(Comando.M);
        comandoList.add(Comando.M);

        Comandos comandos = new Comandos(comandoList);

        Mockito.when(repositorio.buscarPorId(1L)).thenReturn(Optional.ofNullable(sondaCompleta));

        Assert.assertEquals(sondaRetorno, service.explora(1L, comandos));
    }

    @Test
    public void buscarPorId() throws Exception {
        Coordenadas coordenadasPlanalto = new Coordenadas(5, 5);
        Coordenadas coordenadasSonda = new Coordenadas(1, 2);

        Planalto planalto = new Planalto(1L, coordenadasPlanalto);

        Sonda sondaCompleta = new Sonda(1L, coordenadasSonda, Direcao.N, planalto);

        Mockito.when(repositorio.buscarPorId(1L)).thenReturn(Optional.ofNullable(sondaCompleta));

        Assert.assertEquals(sondaCompleta, service.buscarPorId(1L));
    }

}