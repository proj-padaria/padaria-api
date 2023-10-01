package br.com.gar.padaria.repositories;

import br.com.gar.padaria.dtos.ClientesMaiorCompraIntervaloDTO;
import br.com.gar.padaria.dtos.TitulosAPagarDTO;
import br.com.gar.padaria.models.Pagar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PagarRepository extends JpaRepository<Pagar,Integer> {

    @Query(value =  "SELECT pg.fornecedor_id, pg.compra_id, p.nome, pg.data_vencimento, SUM (pg.valor - pg.valor_pago) AS valor_a_pagar " +
            "FROM pagar pg " +
            "	INNER JOIN fornecedores f " +
            "		ON pg.fornecedor_id = f.id " +
            "	INNER JOIN pessoas p " +
            "		ON f.pessoa_id = p.id " +
            "WHERE pg.data_vencimento <= current_date " +
            "GROUP BY pg.fornecedor_id, pg.compra_id,p.nome, pg.data_vencimento, pg.valor " +
            "ORDER BY data_vencimento " , nativeQuery = true)

    List<TitulosAPagarDTO> titulos_a_pagar_ate_hoje();

}
