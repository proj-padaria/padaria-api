package br.com.gar.padaria.repositories;
import br.com.gar.padaria.dtos.ClientesMaiorCompraIntervaloDTO;
import br.com.gar.padaria.models.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendasRepository  extends JpaRepository<Vendas, Integer> {

    @Query(value =  "SELECT v.cliente_id, p.nome, SUM(v.valor_total) AS valor_total_gasto " +
            "FROM vendas v " +
            "INNER JOIN pessoas p " +
            "ON v.cliente_id = p.id " +
            "WHERE v.data_fim BETWEEN '20/09/2023' AND '30/09/2023' " +
            "GROUP BY p.nome, v.cliente_id " +
            "ORDER BY valor_total_gasto DESC ", nativeQuery = true)

    List<ClientesMaiorCompraIntervaloDTO> clientes_maior_compra_intervalo();
}
