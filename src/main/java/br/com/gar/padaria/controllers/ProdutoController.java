package br.com.gar.padaria.controllers;
import br.com.gar.padaria.dtos.*;
import br.com.gar.padaria.models.Produto;
import br.com.gar.padaria.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("vendasMediaPorSemana/{dataInicial}/{dataFinal}")
    public List<VendasMediaPorSemanaDTO> vendas_media_por_semana(@PathVariable("dataInicial") LocalDate dataInicial,
                                                           @PathVariable("dataFinal") LocalDate dataFinal){
        return produtoRepository.vendas_media_por_semana(dataInicial, dataFinal);
    }

    @GetMapping("vendasMediaPorQuinzena/{dataInicial}/{dataFinal}")
    public List<VendasMediaPorQuinzenaDTO> vendas_media_por_quinzena(@PathVariable("dataInicial") LocalDate dataInicial,
                                                                     @PathVariable("dataFinal") LocalDate dataFinal){
        return produtoRepository.vendas_media_por_quinzena(dataInicial, dataFinal);
    }

    @GetMapping("vendasMediaPorMes/{dataInicial}/{dataFinal}")
    public List<VendasMediaPorMesDTO> vendas_media_por_mes(@PathVariable("dataInicial") LocalDate dataInicial,
                                                           @PathVariable("dataFinal") LocalDate dataFinal){
        return produtoRepository.vendas_media_por_mes(dataInicial, dataFinal);
    }

    @GetMapping("vendasMediaPorTrimestre/{dataInicial}/{dataFinal}")
    public List<VendasMediaPorTrimestreDTO> vendas_media_por_trimestre(@PathVariable("dataInicial") LocalDate dataInicial,
                                                           @PathVariable("dataFinal") LocalDate dataFinal){
        return produtoRepository.vendas_media_por_trimestre(dataInicial, dataFinal);
    }

    @GetMapping("vendasMediaPorBairro/{dataInicial}/{dataFinal}")
    public List<VendasMediaPorBairroDTO> f_venda_media_bairro(@PathVariable("dataInicial") LocalDate dataInicial,
                                                                       @PathVariable("dataFinal") LocalDate dataFinal){
        return produtoRepository.f_venda_media_bairro(dataInicial, dataFinal);
    }


}
