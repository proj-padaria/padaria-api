package br.com.gar.padaria.repositories;

import br.com.gar.padaria.dtos.ComprasVendasUltimoAnoDTO;
import br.com.gar.padaria.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Integer> {

    @Query(value = "select * from f_compras_vendas_12_meses()", nativeQuery = true)
    List<ComprasVendasUltimoAnoDTO> compras_vendas_ultimo_ano();
}
