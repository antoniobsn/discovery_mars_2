package br.com.absn.controller;

import br.com.absn.controller.mapper.PlanaltoMapper;
import br.com.absn.controller.mapper.SondaMapper;
import br.com.absn.controller.request.PlanaltoRequest;
import br.com.absn.controller.request.SondaRequest;
import br.com.absn.model.Planalto;
import br.com.absn.repository.PlanaltoRepository;
import br.com.absn.service.PlanaltoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by asampaio on 19/10/17.
 */

@RestController
@RequestMapping("/api/v1/planalto")
public class PlanaltoController {

    private final PlanaltoRepository repositorio;
    private final PlanaltoMapper mapper;
    private final PlanaltoService service;
    private final SondaMapper sondaMapper;

    @Autowired
    public PlanaltoController(PlanaltoRepository repositorio,
                              PlanaltoMapper mapper,
                              PlanaltoService service,
                              SondaMapper sondaMapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
        this.service = service;
        this.sondaMapper = sondaMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Planalto cria(@RequestBody final PlanaltoRequest planaltoRequest){
        return repositorio.cria(mapper.convertePlanaltoRequestEmPlanalto(planaltoRequest));
    }

    @PatchMapping("/{id}/sonda")
    @ResponseStatus(HttpStatus.OK)
    public Planalto recebe(@PathVariable("id") final Long id, @RequestBody SondaRequest sondaRequest){
        return service.recebe(sondaMapper.converteRequestEmSonda(sondaRequest), id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Planalto buscaPorId(@PathVariable("id") final Long id){
        return service.buscaPorId(id);
    }

}
