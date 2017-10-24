package br.com.absn.model.enums;

import br.com.absn.model.Sonda;
import br.com.absn.model.tinytypes.Localizacao;

/**
 * Created by asampaio on 28/09/17.
 */
public enum Comando {
    L{
        public Localizacao movimentar(Sonda sonda) {
            return sonda.getDirecao().virarParaEsquerda(sonda);
        }
    },
    R{
        public Localizacao movimentar(Sonda sonda) {
            return sonda.getDirecao().virarParaDireita(sonda);
        }
    },
    M{
        public Localizacao movimentar(Sonda sonda) {
            return sonda.getDirecao().moverParaFrente(sonda);
        }
    };

    public abstract Localizacao movimentar(Sonda sonda);

}
