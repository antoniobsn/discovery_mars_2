package br.com.absn.controller.request;

import br.com.absn.model.enums.Direcao;
import br.com.absn.model.tinytypes.Coordenadas;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by antonio on 20/10/17.
 */
public class SondaRequest {

    @JsonProperty("coordenadas")
    private Coordenadas coordenadas;

    @JsonProperty("direcao")
    private Direcao direcao;

    @JsonCreator
    public SondaRequest(@JsonProperty("coordenadas")Coordenadas coordenadas,
                 @JsonProperty("direcao")Direcao direcao) {
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
