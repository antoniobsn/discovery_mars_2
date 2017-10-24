package br.com.absn.model.tinytypes;

import br.com.absn.exception.business.LimiteExcedidoException;
import br.com.absn.model.Planalto;
import br.com.absn.model.enums.Direcao;

/**
 * Created by asampaio on 03/10/17.
 */
public class Localizacao {

    private Coordenadas coordenadas;
    private Direcao direcao;

    public Localizacao(Coordenadas coordenadas, Direcao direcao) {
        this.coordenadas = coordenadas;
        this.direcao = direcao;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public Direcao getDirecao() {
        return direcao;
    }
}
