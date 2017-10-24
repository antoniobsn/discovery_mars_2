package br.com.absn.model;

import br.com.absn.model.tinytypes.Coordenadas;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by asampaio on 19/10/17.
 */
@JsonRootName(value = "planalto")
@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT,use= JsonTypeInfo.Id.NAME)
public class Planalto implements Serializable{

    private static final long serialVersionUID = 4565543361297272382L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("coordenadas")
    private Coordenadas coordenadas;

    @JsonProperty("sondas")
    private List<Sonda> sondas;

    public Planalto(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
        this.sondas = new ArrayList<>();
    }

    public Planalto(Long id, Coordenadas coordenadas) {
        this(coordenadas);
        this.id = id;
    }

    public Planalto(Long id, Coordenadas coordenadas, List<Sonda> sondas) {
        this(id, coordenadas);
        this.sondas = sondas;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public Long getId() {
        return id;
    }

    public List<Sonda> getSondas() {
        return sondas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planalto planalto = (Planalto) o;
        return Objects.equals(id, planalto.id) &&
                Objects.equals(coordenadas, planalto.coordenadas) &&
                Objects.equals(sondas, planalto.sondas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coordenadas, sondas);
    }
}
