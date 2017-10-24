package br.com.absn.repository;

import br.com.absn.model.Planalto;
import br.com.absn.model.Sonda;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by asampaio on 19/10/17.
 */

@Repository
public class SondaRepository {

    private static Map<Long, Sonda> sondaStub = new HashMap<>();
    private static Long idSonda = 0L;

    public Optional<Sonda> buscarPorId(Long id) {
        return Optional.ofNullable(sondaStub.get(id));
    }

    public Sonda cria(Sonda sonda, Planalto planalto) {
        sondaStub.put(++idSonda,
                new Sonda(idSonda, sonda.getCoordenadas(), sonda.getDirecao(), planalto));

        return buscarPorId(idSonda).get();

    }
}
