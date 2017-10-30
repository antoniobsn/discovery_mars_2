package br.com.absn.repository;

import br.com.absn.model.Planalto;
import br.com.absn.model.Sonda;
import br.com.absn.repository.interfaces.ISondaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by asampaio on 19/10/17.
 */

@Repository
public class SondaRepository implements ISondaRepository {

    private static Map<Long, Sonda> sondaStub = new HashMap<>();
    private static Long idSonda = 0L;

    @Override
    public Optional<Sonda> buscarPorId(Long id) {
        return Optional.ofNullable(sondaStub.get(id));
    }

    @Override
    public Sonda cria(Sonda sonda, Planalto planalto) {
        sondaStub.put(++idSonda,
                new Sonda(idSonda, sonda.getCoordenadas(), sonda.getDirecao(), planalto));

        return buscarPorId(idSonda).get();

    }
}
