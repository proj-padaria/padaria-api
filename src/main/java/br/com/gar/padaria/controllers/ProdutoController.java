package br.com.gar.padaria.controllers;
import br.com.gar.padaria.dtos.ProdutosMargemMenorDTO;
import br.com.gar.padaria.dtos.VendasDiaSemanaDTO;
import br.com.gar.padaria.dtos.VerificaPontoPedidoDTO;
import br.com.gar.padaria.models.Produto;
import br.com.gar.padaria.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("list")
    public List<Produto> findall() {
        return produtoRepository.findAll();
    }

    @GetMapping("id/{id}")
    public Produto selectById(@PathVariable Integer id) {
        return produtoRepository.findById(id).get();
    }

    @PostMapping("save")
    public Produto produto(@RequestBody Produto produtoModel) {
        Produto produto = produtoRepository.save(produtoModel);
        return produto;
    }

    @DeleteMapping("delete/{id}")
    public void produtoDeleteById(@PathVariable Integer id) {
        produtoRepository.deleteById(id);
    }

    @GetMapping("reajustarPreco/{percentualReajuste}")
    public int reajustarPreco(@PathVariable("percentualReajuste") Float percentualReajuste) {
        return produtoRepository.f_reajuste_preco_venda(percentualReajuste);
    }

    @GetMapping("estoquePontoPedido")
    public List<VerificaPontoPedidoDTO> verifica_ponto_pedido() {
        return produtoRepository.verifica_ponto_pedido();
    }

    @GetMapping("produtosMargemMenor/{porcentagem}")
    public List<ProdutosMargemMenorDTO> produtos_margem_menor(@PathVariable("porcentagem") Float porcentagem) {
        return produtoRepository.produtos_margem_menor(porcentagem);
    }

    @GetMapping("vendasDiaSemana/{dataInicial}/{dataFinal}")
    public List<VendasDiaSemanaDTO> vendas_dia_semana(@PathVariable("dataInicial") LocalDate dataInicial,
                                                      @PathVariable("dataFinal") LocalDate dataFinal){
        return produtoRepository.vendas_dia_semana(dataInicial, dataFinal);
    }
}
