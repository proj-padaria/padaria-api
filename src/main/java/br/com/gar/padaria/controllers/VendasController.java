package br.com.gar.padaria.controllers;

import br.com.gar.padaria.dtos.ClientesMaiorCompraIntervaloDTO;
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
    public List<ClientesMaiorCompraIntervaloDTO> cliente_maior_valor_compra(@PathVariable Date dataInicial, @PathVariable Date dataFinal) {
        return vendasRepository.cliente_maior_valor_compra(dataInicial, dataFinal);
    }



   /* @GetMapping("clientesMaiorCompraIntervalo/{di}/{df}")
    public List<ClientesMaiorCompraIntervaloDTO> cliente_maior_valor_compra(
            @RequestParam("dataInicial") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFinal) {
        // Faça o processamento com as datas aqui
        return vendasRepository.cliente_maior_valor_compra(dataInicial, dataFinal);

}*/

    @GetMapping("clientesMaiorCompraIntervalo/{di}/{df}")
    public List<ClientesMaiorCompraIntervaloDTO> cliente_maior_valor_compra(@PathVariable @DateTimeFormat String di, @PathVariable @DateTimeFormat String df) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dataInicial = dateFormat.parse(di);
            Date dataFinal = dateFormat.parse(df);
            // Use parsedDate in your code
        } catch (ParseException e) {
            // Handle the parsing exception
        }

        return null;
    }

}
