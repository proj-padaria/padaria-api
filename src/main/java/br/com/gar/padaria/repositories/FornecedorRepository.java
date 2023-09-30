package br.com.gar.padaria.repositories;
import br.com.gar.padaria.dtos.FornecedorMaiorGastoDTO;
import br.com.gar.padaria.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    List<Fornecedor> findAll();

    @Query(value =  "SELECT c.fornecedor_id, SUM (c.valor_total_recebido) AS valor_total_no_periodo " +
                    "FROM compras c " +
                    "	INNER JOIN fornecedores f " +
                    "		ON f.id = c.fornecedor_id " +
                    "	INNER JOIN pessoas p " +
                    "		ON p.id = f.pessoa_id " +
                    "WHERE c.data_recebimento BETWEEN '01/09/2023' AND '30/09/2023' " +
                    "GROUP BY c.fornecedor_id " +
                    "ORDER BY valor_total_no_periodo DESC ", nativeQuery = true)

    List<FornecedorMaiorGastoDTO> fornecedor_maior_gasto();

}



