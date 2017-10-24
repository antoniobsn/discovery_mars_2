package br.com.absn.model.tinytypes;

import br.com.absn.exception.business.LimiteExcedidoException;
import br.com.absn.model.Planalto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by antonio on 24/10/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class CoordenadasTest {

    @Test(expected = LimiteExcedidoException.class)
    public void verificaLimitesPermitidos() throws Exception {

        Coordenadas coordenadasPlanalto = new Coordenadas(5, 5);
        Coordenadas coordenadasSonda = new Coordenadas(1, 6);

        Planalto planalto = new Planalto(1L, coordenadasPlanalto);

        coordenadasSonda.verificaLimitesPermitidos(planalto);
    }

}