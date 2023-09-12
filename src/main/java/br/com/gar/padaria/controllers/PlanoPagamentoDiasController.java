package br.com.gar.padaria.controllers;
import br.com.gar.padaria.repositories.PlanosPagamentoDiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/planospagamentodias")
public class PlanosPagamentoDiasController {

    @Autowired
    private PlanosPagamentoDiasRepository planosPagamentoDiasRepository;

}
