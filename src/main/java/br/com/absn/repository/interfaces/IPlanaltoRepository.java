package br.com.absn.repository.interfaces;

import br.com.absn.model.Planalto;

import java.util.Optional;

/**
 * Created by asampaio on 30/10/17.
 */
public interface IPlanaltoRepository {

    Planalto cria(Planalto planalto);

    Optional<Planalto> buscaPorId(Long id);

    Planalto persiste(Planalto planalto);
}
