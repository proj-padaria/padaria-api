package br.com.gar.padaria.repositories;
import br.com.gar.padaria.dtos.ClientesMaiorCompraIntervaloDTO;
import br.com.gar.padaria.models.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface VendasRepository  extends JpaRepository<Vendas, Integer> {

    @Query(value =  "SELECT v.cliente_id, p.nome, SUM(v.valor_total) AS valor_total_gasto " +
            "        FROM vendas v " +
            "           INNER JOIN pessoas p " +
            "                 ON v.cliente_id = p.id " +
            "        WHERE v.data BETWEEN ?1 AND ?2 " +
            "        GROUP BY v.cliente_id, p.nome " +
            "        ORDER BY valor_total_gasto DESC; ", nativeQuery = true)

    List<ClientesMaiorCompraIntervaloDTO> cliente_maior_valor_compra(LocalDate dataInicial, LocalDate dataFinal);

}
