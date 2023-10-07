package br.com.gar.padaria.repositories;
import br.com.gar.padaria.dtos.ProdutosMargemMenorDTO;
import br.com.gar.padaria.dtos.VendasDiaSemanaDTO;
import br.com.gar.padaria.dtos.VendasMediaPorSemanaDTO;
import br.com.gar.padaria.dtos.VerificaPontoPedidoDTO;
import br.com.gar.padaria.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    @Query(value = "select * from f_reajuste_preco_venda(?1)", nativeQuery = true)
    int f_reajuste_preco_venda(Float percentualReajuste);

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

    @Query(value = "SELECT p.id, p.nome, " +
            "	   CASE EXTRACT( DOW FROM v.data) " +
            "               WHEN 0 THEN 'Domingo'     " +
            "               WHEN 1 THEN 'Segunda'     " +
            "               WHEN 2 THEN 'Terça'     " +
            "               WHEN 3 THEN 'Quarta'     " +
            "               WHEN 4 THEN 'Quinta'     " +
            "               WHEN 5 THEN 'Sexta'     " +
            "               WHEN 6 THEN 'Sábado'     " +
            "			   END AS dia_da_semana,     " +
            "	   SUM(vi.quantidade) AS quantidade_media_vendida     " +
            " FROM produtos p     " +
            "	 INNER JOIN vendas_itens vi     " +
            "	 	ON p.id = vi.produto_id     " +
            "	 INNER JOIN vendas v      " +
            "	 	ON vi.venda_id = v.id     " +
            " WHERE v.data BETWEEN ?1 AND ?2   " +
            " GROUP BY p.id,p.nome , dia_da_semana,v.data     " +
            " ORDER BY p.id    " , nativeQuery = true)

    List<VendasDiaSemanaDTO> vendas_dia_semana(LocalDate dataInicial, LocalDate dataFinal);

    @Query(value = "SELECT p.id, p.nome,      " +
            "	        SUM(vi.quantidade/7) AS quantidade_media_por_semana     " +
            "	    FROM produtos p     " +
            "	        INNER JOIN vendas_itens vi     " +
            "       	   	ON p.id = vi.produto_id     " +
            "	        INNER JOIN vendas v      " +
            "	 	        ON vi.venda_id = v.id     " +
            "	    WHERE v.data BETWEEN ?1 AND ?2     " +
            "	    GROUP BY p.id,p.nome      " +
            "	    ORDER BY p.id     "  , nativeQuery = true)

    List<VendasMediaPorSemanaDTO> vendas_media_por_semana(LocalDate dataInicial, LocalDate dataFinal);
}
