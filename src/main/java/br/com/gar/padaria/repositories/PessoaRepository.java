package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Pessoa findByNomeIgnoreCase(String nome);

    List<Pessoa> findByOrderByNomeAsc();

    List<Pessoa> findByOrderByNomeDesc();

    /*@Query("SELECT c FROM Pessoa p " +
            "WHERE p.id = (SELECT cc.cliente.id FROM Compra cc " +
            "WHERE cc.dataCompra BETWEEN :dataInicial AND :dataFinal " +
            "ORDER BY cc.valor DESC LIMIT 1)")
    Pessoa findClienteComMaiorCompraNoIntervalo(@Param("dataInicial")
                                                LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal); */
}
