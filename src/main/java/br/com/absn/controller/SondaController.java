package br.com.absn.controller;

import br.com.absn.model.Sonda;
import br.com.absn.model.tinytypes.Comandos;
import br.com.absn.service.SondaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by asampaio on 19/10/17.
 */

@RestController
@RequestMapping("/api/v1/sonda")
public class SondaController {

    private final SondaService servico;

    @Autowired
    public SondaController(SondaService servico) {
        this.servico = servico;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Sonda buscarPorId(@PathVariable("id") final Long id){
        return servico.buscarPorId(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Sonda explorar(@PathVariable("id") final Long id, @RequestBody final Comandos comandos){
        return servico.explora(id, comandos);
    }
}
