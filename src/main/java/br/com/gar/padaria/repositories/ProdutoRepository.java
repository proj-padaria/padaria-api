package br.com.gar.padaria.repositories;
import br.com.gar.padaria.dtos.*;
import br.com.gar.padaria.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    @Query(value = "SELECT p.departamento_id, p.id, p.nome, p.preco_venda, ci.preco_unitario " +
                    "FROM produtos p " +
                    "   INNER JOIN compras_itens ci " +
                    "       ON p.id = ci.produto_id " +
                    "WHERE (((p.preco_venda / ci.preco_unitario) - 1) * 100 < ?1) " +
                    "ORDER BY p.nome, ci.preco_unitario, p.preco_venda, p.id, p.departamento_id" , nativeQuery = true)

    List<ProdutosMargemMenorDTO> produtos_margem_menor(Float porcentagem);



    @Query(value = "SELECT p.id, p.nome,      " +
            "	        SUM(vi.quantidade/15) AS quantidade_media_por_quinzena     " +
            "	    FROM produtos p     " +
            "	        INNER JOIN vendas_itens vi     " +
            "       	   	ON p.id = vi.produto_id     " +
            "	        INNER JOIN vendas v      " +
            "	 	        ON vi.venda_id = v.id     " +
            "	    WHERE v.data BETWEEN ?1 AND ?2     " +
            "	    GROUP BY p.id,p.nome      " +
            "	    ORDER BY p.id     "  , nativeQuery = true)

    List<VendasMediaPorQuinzenaDTO> vendas_media_por_quinzena(LocalDate dataInicial, LocalDate dataFinal);

    @Query(value = "SELECT p.id, p.nome,      " +
            "	        SUM(vi.quantidade/30) AS quantidade_media_por_mes     " +
            "	    FROM produtos p     " +
            "	        INNER JOIN vendas_itens vi     " +
            "       	   	ON p.id = vi.produto_id     " +
            "	        INNER JOIN vendas v      " +
            "	 	        ON vi.venda_id = v.id     " +
            "	    WHERE v.data BETWEEN ?1 AND ?2     " +
            "	    GROUP BY p.id,p.nome      " +
            "	    ORDER BY p.id     "  , nativeQuery = true)

    List<VendasMediaPorMesDTO> vendas_media_por_mes(LocalDate dataInicial, LocalDate dataFinal);

    @Query(value = "SELECT p.id, p.nome,      " +
            "	        SUM(vi.quantidade/90) AS quantidade_media_por_trimestre     " +
            "	    FROM produtos p     " +
            "	        INNER JOIN vendas_itens vi     " +
            "       	   	ON p.id = vi.produto_id     " +
            "	        INNER JOIN vendas v      " +
            "	 	        ON vi.venda_id = v.id     " +
            "	    WHERE v.data BETWEEN ?1 AND ?2     " +
            "	    GROUP BY p.id,p.nome      " +
            "	    ORDER BY p.id     "  , nativeQuery = true)

    List<VendasMediaPorTrimestreDTO> vendas_media_por_trimestre(LocalDate dataInicial, LocalDate dataFinal);

    @Query(value = "select * from f_venda_media_bairro(?1,?2)", nativeQuery = true)
    List<VendasMediaPorBairroDTO> f_venda_media_bairro(LocalDate dataInicial, LocalDate dataFinal);

}

