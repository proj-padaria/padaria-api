package br.com.gar.padaria.controllers;
import br.com.gar.padaria.dtos.ProdutosMargemMenorDTO;
import br.com.gar.padaria.dtos.VerificaPontoPedidoDTO;
import br.com.gar.padaria.models.Produto;
import br.com.gar.padaria.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public int reajustarPreco(@PathVariable("percentualReajuste") Double percentualReajuste) {
        return produtoRepository.f_reajuste_preco_venda(percentualReajuste);
    }

    @GetMapping("estoquePontoPedido")
<<<<<<< HEAD
     public List<VerificaPontoPedidoDTO> verifica_ponto_pedido() {
            return produtoRepository.verifica_ponto_pedido();
=======
    public List<VerificaPontoPedidoDTO> verifica_ponto_pedido() {
        return produtoRepository.verifica_ponto_pedido();
>>>>>>> 22151d4f135d3c970a3a24d20a5f547c899ed664
    }

    @GetMapping("produtosMargemMenor")
    public List<ProdutosMargemMenorDTO> produtos_margem_menor() {
        return produtoRepository.produtos_margem_menor();
    }
}
