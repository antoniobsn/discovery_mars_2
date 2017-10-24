package br.com.absn.controller.request;

import br.com.absn.model.tinytypes.Coordenadas;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by antonio on 20/10/17.
 */
public class PlanaltoRequest {

    @JsonProperty("coordenadas")
    private Coordenadas coordenadas;

    @JsonCreator
    public PlanaltoRequest(@JsonProperty("coordenadas") Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }
}
