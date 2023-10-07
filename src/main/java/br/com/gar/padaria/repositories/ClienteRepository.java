package br.com.gar.padaria.repositories;
import br.com.gar.padaria.dtos.ClientesInadimplentesDTO;
import br.com.gar.padaria.dtos.ClientesSemComprarDTO;
import br.com.gar.padaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

    List<Cliente> findAll();

    @Query(value =  "SELECT p.nome, c.dia_vencimento_fiado, r.valor, r.data_vencimento, min(r.data_vencimento) AS data_maior_atraso " +
                    "FROM clientes c " +
                    "   INNER JOIN pessoas p " +
                    "       ON c.pessoa_id = p.id " +
                    "   INNER JOIN receber r " +
                    "       ON r.cliente_id = p.id " +
                    "WHERE r.data_vencimento < current_date " +
                    "GROUP BY p.nome, c.dia_vencimento_fiado, r.valor, r.data_vencimento " +
                    "ORDER BY p.nome ", nativeQuery = true)

    List<ClientesInadimplentesDTO> clientes_inadimplentes();


    @Query(value =  "SELECT v.cliente_id, p.nome, max(v.data_fim) AS data_ultima_compra " +
                    "FROM vendas v " +
                    "   INNER JOIN pessoas p " +
                    "       ON v.cliente_id = p.id " +
                    "WHERE v.data_fim <= (current_date - 20) " +
                    "GROUP BY v.cliente_id, p.nome" , nativeQuery = true)

    List<ClientesSemComprarDTO> clientes_sem_comprar_mais_vinte_dias();
}
