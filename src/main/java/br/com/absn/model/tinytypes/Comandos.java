package br.com.absn.model.tinytypes;

import br.com.absn.model.enums.Comando;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by antonio on 23/10/17.
 */
public class Comandos implements Serializable{
    private static final long serialVersionUID = 6279288081079108664L;

    private List<Comando> comandos;

    @JsonCreator
    public Comandos(@JsonProperty("comandos") List<Comando> comandos) {
        this.comandos = comandos;
    }

    public List<Comando> getComandos() {
        return comandos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comandos comandos1 = (Comandos) o;
        return Objects.equals(comandos, comandos1.comandos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comandos);
    }
}
