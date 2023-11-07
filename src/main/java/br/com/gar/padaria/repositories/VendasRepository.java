package br.com.gar.padaria.repositories;
import br.com.gar.padaria.dtos.ClientesMaiorCompraIntervaloDTO;
import br.com.gar.padaria.dtos.ComprasVendasUltimoAnoDTO;
import br.com.gar.padaria.dtos.ValorTicketMedioEquantidadEVisitasDTO;
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


    @Query(value =" SELECT COUNT(ID) AS quantidade_visitas,  " +
            " 		ROUND(AVG(v.valor_total),2)AS valor_ticket_medio,  " +
            " 		   CASE extract (MONTH FROM v.data)  " +
            "          WHEN 1 THEN 'Janeiro' " +
            "          WHEN 2 THEN 'Fevereiro' " +
            "          WHEN 3 THEN 'Março' " +
            "          WHEN 4 THEN 'Abril' " +
            "          WHEN 5 THEN 'Maio' " +
            "          WHEN 6 THEN 'Junho' " +
            "          WHEN 7 THEN 'Julho' " +
            "          WHEN 8 THEN 'Agosto' " +
            "          WHEN 9 THEN 'Setembro' " +
            "          WHEN 10 THEN 'Outubro' " +
            "          WHEN 11 THEN 'Novembro' " +
            "          WHEN 12 THEN 'Dezembro' " +
            "        END AS mes_venda " +
            " FROM vendas v " +
            " WHERE v.data > CURRENT_DATE - interval '365 days' " +
            " GROUP BY mes_venda " +
            " ORDER BY EXTRACT (MONTH FROM CURRENT_DATE) " ,nativeQuery = true )
    List<ValorTicketMedioEquantidadEVisitasDTO> valor_ticket_meio_e_quantidade_visitas();
}
