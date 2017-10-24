package br.com.absn.model.enums;

import br.com.absn.model.Sonda;
import br.com.absn.model.tinytypes.Coordenadas;
import br.com.absn.model.tinytypes.Localizacao;

/**
 * Created by asampaio on 28/09/17.
 */
public enum Direcao {
    N {
        public Localizacao virarParaDireita(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.E);
        }

        public Localizacao virarParaEsquerda(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.W);
        }

        public Localizacao moverParaFrente(Sonda sonda) {
            return new Localizacao(
                    new Coordenadas(sonda.getCoordenadas().getX(), sonda.getCoordenadas().getY()+1),
                    sonda.getDirecao());
        }
    }, E {
        public Localizacao virarParaDireita(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.S);
        }

        public Localizacao virarParaEsquerda(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.N);
        }

        public Localizacao moverParaFrente(Sonda sonda) {
            return new Localizacao(
                    new Coordenadas(sonda.getCoordenadas().getX()+1, sonda.getCoordenadas().getY()),
                    sonda.getDirecao());
        }
    }, S {
        public Localizacao virarParaDireita(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.W);
        }

        public Localizacao virarParaEsquerda(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.E);
        }

        public Localizacao moverParaFrente(Sonda sonda) {
            return new Localizacao(
                    new Coordenadas(sonda.getCoordenadas().getX(), sonda.getCoordenadas().getY()-1),
                    sonda.getDirecao());
        }
    }, W {
        public Localizacao virarParaDireita(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.N);
        }

        public Localizacao virarParaEsquerda(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.S);
        }

        public Localizacao moverParaFrente(Sonda sonda) {
            return new Localizacao(
                    new Coordenadas(sonda.getCoordenadas().getX()-1, sonda.getCoordenadas().getY()),
                    sonda.getDirecao());
        }
    };

    public abstract Localizacao virarParaDireita(Sonda sonda);

    public abstract Localizacao virarParaEsquerda(Sonda sonda);

    public abstract Localizacao moverParaFrente(Sonda sonda);
}
