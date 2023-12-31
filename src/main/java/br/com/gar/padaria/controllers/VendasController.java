package br.com.gar.padaria.controllers;

import br.com.gar.padaria.dtos.ClientesMaiorCompraIntervaloDTO;
import br.com.gar.padaria.dtos.ComprasVendasUltimoAnoDTO;
import br.com.gar.padaria.dtos.ValorTicketMedioEquantidadEVisitasDTO;
import br.com.gar.padaria.models.Cliente;
import br.com.gar.padaria.models.Vendas;
import br.com.gar.padaria.repositories.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/vendas")


public class VendasController {

    @Autowired
    private VendasRepository vendasRepository;

    @GetMapping("list")
    public List<Vendas> findAll() {
        return vendasRepository.findAll();
    }

    @GetMapping("id/{id}")
    public Vendas selectedById(@PathVariable Integer id) {
        return vendasRepository.findById(id).get();
    }

    @PostMapping(value = "/save")
    public Vendas vendasSave(@RequestBody Vendas vendasModel) {
        return vendasRepository.save(vendasModel);
    }

    @DeleteMapping(value = "delete/{id}")
    public void clienteDeleteById(@PathVariable Integer id) {
        vendasRepository.deleteById(id);
    }

    @GetMapping("clientesMaiorCompraIntervalo/{dataInicial}/{dataFinal}")
    public List<ClientesMaiorCompraIntervaloDTO> cliente_maior_valor_compra(@PathVariable LocalDate dataInicial,
                                                                            @PathVariable LocalDate dataFinal) {
        return vendasRepository.cliente_maior_valor_compra(dataInicial, dataFinal);
    }
    @GetMapping("valorTicketMedioEQuantidadeVisitas")
    public List<ValorTicketMedioEquantidadEVisitasDTO> valor_ticket_meio_e_quantidade_visitas(){
        return vendasRepository.valor_ticket_meio_e_quantidade_visitas();
    }

}
