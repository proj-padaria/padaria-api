package br.com.gar.padaria.repositories;
import br.com.gar.padaria.dtos.ClientesMaiorCompraIntervaloDTO;
import br.com.gar.padaria.models.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface VendasRepository  extends JpaRepository<Vendas, Integer> {

    @Query(value =  "SELECT * FROM f_cliente_maior_valor_compra(?2) ", nativeQuery = true)
    List<ClientesMaiorCompraIntervaloDTO> cliente_maior_valor_compra(Date dataInicial, Date dataFinal);

}
