package br.com.absn.service;

import br.com.absn.exception.business.SondaNaoEncontrada;
import br.com.absn.model.Planalto;
import br.com.absn.model.Sonda;
import br.com.absn.model.tinytypes.Comandos;
import br.com.absn.repository.SondaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by antonio on 20/10/17.
 */

@Service
public class SondaService {

    private final SondaRepository repositorio;

    @Autowired
    public SondaService(SondaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Sonda cria(Sonda sonda, Planalto planalto) {
        sonda.getCoordenadas().verificaLimitesPermitidos(planalto);
        return repositorio.cria(sonda, planalto);
    }

    public Sonda explora(Long id, Comandos comandos){
        Optional<Sonda> sonda = repositorio.buscarPorId(id);
        return sonda.map(s -> s.explorar(comandos))
                    .orElseThrow(() -> new SondaNaoEncontrada("Não existe Sonda com o id: "+id));
    }

    public Sonda buscarPorId(Long id) {
        Optional<Sonda> sonda = repositorio.buscarPorId(id);
        return sonda.orElseThrow(() -> new SondaNaoEncontrada("Não existe Sonda com o id: "+id));
    }
}
