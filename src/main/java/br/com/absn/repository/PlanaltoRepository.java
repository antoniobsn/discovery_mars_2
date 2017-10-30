package br.com.absn.repository;

import br.com.absn.model.Planalto;
import br.com.absn.repository.interfaces.IPlanaltoRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by asampaio on 19/10/17.
 */

@Repository
public class PlanaltoRepository implements IPlanaltoRepository {

    private static Map<Long, Planalto> planaltoStub = new HashMap<>();
    private static Long planaltoId = 0L;

    @Override
    public Planalto cria(Planalto planalto) {
        planaltoStub.put(++planaltoId, new Planalto(planaltoId, planalto.getCoordenadas()));
        return buscaPorId(planaltoId).get();
    }

    @Override
    public Optional<Planalto> buscaPorId(Long id){
        return Optional.ofNullable(planaltoStub.get(id));
    }

    @Override
    public Planalto persiste(Planalto planalto) {

        planaltoStub.remove(planalto.getId());
        planaltoStub.put(planalto.getId(), planalto);

        return planalto;
    }
}
