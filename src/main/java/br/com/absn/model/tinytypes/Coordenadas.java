package br.com.absn.model.tinytypes;

import br.com.absn.exception.business.LimiteExcedidoException;
import br.com.absn.model.Planalto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by asampaio on 29/09/17.
 */
public class Coordenadas implements Serializable{

    private static final long serialVersionUID = -3835584888606425131L;

    @JsonProperty("x")
    private int x;

    @JsonProperty("y")
    private int y;

    @JsonCreator
    public Coordenadas(@JsonProperty("x")int x,
                       @JsonProperty("y")int y) {
        this.x = x;
        this.y = y;
    }

    public void verificaLimitesPermitidos(Planalto planalto){
        if(planalto.getCoordenadas().getX() < this.getX() ||
                planalto.getCoordenadas().getY() < this.getY()){
            throw new LimiteExcedidoException("Nao e permitido ultrapassar os limites do planalto");
        }else if(0 > this.getX() || 0 > this.getY()){
            throw new LimiteExcedidoException("Nao e permitido ultrapassar os limites do planalto");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordenadas)) return false;
        Coordenadas that = (Coordenadas) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
