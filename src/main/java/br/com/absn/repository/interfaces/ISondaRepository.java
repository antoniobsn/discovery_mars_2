package br.com.absn.repository.interfaces;

import br.com.absn.model.Planalto;
import br.com.absn.model.Sonda;

import java.util.Optional;

/**
 * Created by asampaio on 30/10/17.
 */
public interface ISondaRepository {

    Optional<Sonda> buscarPorId(Long id);

    Sonda cria(Sonda sonda, Planalto planalto);
}
