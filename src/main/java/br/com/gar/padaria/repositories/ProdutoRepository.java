package br.com.gar.padaria.repositories;
import br.com.gar.padaria.dtos.ClientesInadimplentesDTO;
import br.com.gar.padaria.dtos.ProdutosMargemMenorDTO;
import br.com.gar.padaria.dtos.VerificaPontoPedidoDTO;
import br.com.gar.padaria.models.Pessoa;
import br.com.gar.padaria.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    @Query(value = "select * from f_reajuste_preco_venda(?1)", nativeQuery = true)
    int f_reajuste_preco_venda(Double percentualReajuste);

    @Query(value = "SELECT id,departamento_id, " +
            "             nome,quantidade_em_estoque, ponto_pedido, " +
            "             CASE " +
            "               WHEN ponto_pedido > 0 THEN " +
            "                    quantidade_em_estoque/ponto_pedido " +
            "               ELSE " +
            "                     0 " +
            "             END AS percentual " +
            "       FROM produtos " +
            "       WHERE quantidade_em_estoque <= ponto_pedido " +
            "       ORDER BY percentual ", nativeQuery = true)

    List<VerificaPontoPedidoDTO> verifica_ponto_pedido();

    @Query(value = "SELECT p.departamento_id, ci.produto_id, p.nome, p.preco_venda, ci.preco_unitario " +
            "       FROM produtos p" +
            "       INNER JOIN compras_itens ci" +
            "       ON ci.produto_id = p.id " +
            "       WHERE (((p.preco_venda / ci.preco_unitario) - 1) * 100 = 28.7) " +
            "       ORDER BY p.nome ", nativeQuery = true)

    List<ProdutosMargemMenorDTO> produtos_margem_menor();
    }
