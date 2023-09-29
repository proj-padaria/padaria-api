package br.com.gar.padaria.repositories;
import br.com.gar.padaria.dtos.ClientesInadimplentesDTO;
import br.com.gar.padaria.dtos.VerificaPontoPedidoDTO;
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
}
