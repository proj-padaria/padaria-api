package br.com.gar.padaria.repositories;
import br.com.gar.padaria.models.Pessoa;
import br.com.gar.padaria.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    @Query(value = "select * from f_reajuste_preco_venda(?1)",nativeQuery = true)
        int f_reajuste_preco_venda(int percentualReajuste);


    @Query(value = "select * from f_verifica_ponto_pedido(?1)", nativeQuery = true)
         List<Produto> f_verifica_ponto_pedido(int pontoPedidoProduto);

}
