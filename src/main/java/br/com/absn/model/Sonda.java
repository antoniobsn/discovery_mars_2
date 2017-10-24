package br.com.absn.model;

import br.com.absn.model.enums.Comando;
import br.com.absn.model.enums.Direcao;
import br.com.absn.model.tinytypes.Comandos;
import br.com.absn.model.tinytypes.Coordenadas;
import br.com.absn.model.tinytypes.Localizacao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by asampaio on 29/09/17.
 */

@JsonRootName(value = "sonda")
@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT,use= JsonTypeInfo.Id.NAME)
public class Sonda implements Serializable{

    private static final long serialVersionUID = 5228143762274020373L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("coordenadas")
    private Coordenadas coordenadas;

    @JsonProperty("direcao")
    private Direcao direcao;

    @JsonIgnore
    private Planalto planalto;

    public Sonda(Coordenadas coordenadas, Direcao direcao) {
        this.coordenadas = coordenadas;
        this.direcao = direcao;
    }

    public Sonda(Long id, Coordenadas coordenadas, Direcao direcao, Planalto planalto) {
        this.id = id;
        this.coordenadas = coordenadas;
        this.direcao = direcao;
        this.planalto = planalto;
    }

    public Sonda explorar(Comandos comandos) {
        for(Comando comando : comandos.getComandos()){
            Localizacao localizacao = comando.movimentar(this);

            localizacao.getCoordenadas().verificaLimitesPermitidos(planalto);

            setLocalizacao(localizacao);
        }
        return this;
    }

    private void setLocalizacao(Localizacao localizacao) {
        coordenadas = localizacao.getCoordenadas();
        direcao = localizacao.getDirecao();
    }

    public Long getId() {
        return id;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public Planalto getPlanalto() {
        return planalto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sonda sonda = (Sonda) o;
        return Objects.equals(id, sonda.id) &&
                Objects.equals(coordenadas, sonda.coordenadas) &&
                direcao == sonda.direcao &&
                Objects.equals(planalto, sonda.planalto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coordenadas, direcao, planalto);
    }
}
