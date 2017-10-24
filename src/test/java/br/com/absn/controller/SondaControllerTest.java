package br.com.absn.controller;

import br.com.absn.model.Planalto;
import br.com.absn.model.Sonda;
import br.com.absn.model.enums.Comando;
import br.com.absn.model.enums.Direcao;
import br.com.absn.model.tinytypes.Comandos;
import br.com.absn.model.tinytypes.Coordenadas;
import br.com.absn.service.SondaService;
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
public class SondaControllerTest {

    @InjectMocks
    private SondaController controller;

    @Mock
    private SondaService servico;

    @Test
    public void buscarPorId() throws Exception {

        Coordenadas coordenadasPlanalto = new Coordenadas(5, 5);
        Planalto planalto = new Planalto(1L, coordenadasPlanalto);

        Sonda sonda = new Sonda(1L, new Coordenadas(1, 2), Direcao.N, planalto);
        Mockito.when(servico.buscarPorId(1L)).thenReturn(sonda);

        Assert.assertEquals(sonda, controller.buscarPorId(1L));
    }

    @Test
    public void explorar() throws Exception {

        Coordenadas coordenadasPlanalto = new Coordenadas(5, 5);
        Planalto planalto = new Planalto(1L, coordenadasPlanalto);

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

        Sonda sonda = new Sonda(1L, new Coordenadas(1,3), Direcao.N, planalto);

        Mockito.when(servico.explora(1L, comandos)).thenReturn(sonda);

        Assert.assertEquals(sonda, controller.explorar(1L, comandos));
    }

}