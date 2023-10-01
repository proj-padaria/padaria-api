package br.com.gar.padaria.repositories;
import br.com.gar.padaria.dtos.ClientesInadimplentesDTO;
<<<<<<< HEAD
import br.com.gar.padaria.dtos.ClientesSemComprarDTO;
=======
import br.com.gar.padaria.dtos.ClientesMaiorCompraIntervaloDTO;
>>>>>>> d020ddaeabe47bc525b38a5ec6109bbfc5114b66
import br.com.gar.padaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

    List<Cliente> findAll();

    @Query(value = "SELECT nome, dia_vencimento_fiado " +
            "       FROM clientes " +
            "       INNER JOIN pessoas" +
            "       ON pessoa_id = pessoas.id " +
            "       WHERE dia_vencimento_fiado < 20 " +
            "       ORDER BY nome ", nativeQuery = true)

    List<ClientesInadimplentesDTO> clientes_inadimplentes();

<<<<<<< HEAD

    @Query(value =
            "SELECT v.cliente_id, p.nome, max(v.data_fim) AS data_ultima_compra " +
            "FROM vendas v " +
            "   INNER JOIN pessoas p " +
            "       ON v.cliente_id = p.id " +
            "WHERE v.data_fim <= (current_date - 1) " +
            "GROUP BY v.cliente_id, p.nome ", nativeQuery = true)

    List<ClientesSemComprarDTO> clientes_sem_comprar_mais_vinte_dias();
=======
>>>>>>> d020ddaeabe47bc525b38a5ec6109bbfc5114b66
}
