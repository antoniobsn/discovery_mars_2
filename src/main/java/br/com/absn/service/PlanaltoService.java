package br.com.absn.service;

import br.com.absn.exception.business.PlanaltoNaoEncontrado;
import br.com.absn.model.Planalto;
import br.com.absn.model.Sonda;
import br.com.absn.repository.PlanaltoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by asampaio on 23/10/17.
 */

@Service
public class PlanaltoService {

    private final PlanaltoRepository repositorio;
    private final SondaService sondaService;

    @Autowired
    public PlanaltoService(PlanaltoRepository repositorio, SondaService sondaService) {
        this.repositorio = repositorio;
        this.sondaService = sondaService;
    }

    public Planalto recebe(Sonda sonda, Long planaltoId){

        Planalto planalto = buscaPorId(planaltoId);

        Sonda sondaCriada = sondaService.cria(sonda, planalto);

        List<Sonda> sondas = new ArrayList<>();

        sondas.addAll(planalto.getSondas());
        sondas.add(sondaCriada);

        Planalto planaltoAtualizado = new Planalto(planalto.getId(), planalto.getCoordenadas(), sondas);

        return repositorio.persiste(planaltoAtualizado);
    }

    public Planalto buscaPorId(Long planaltoId) {
        Optional<Planalto> planalto = repositorio.buscaPorId(planaltoId);

        return planalto.orElseThrow(() -> new PlanaltoNaoEncontrado("Não existe Planalto com o id: "+planaltoId));
    }
}
