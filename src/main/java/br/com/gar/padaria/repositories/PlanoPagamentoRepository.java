package br.com.gar.padaria.repositories;
import br.com.gar.padaria.models.Empresa;
import br.com.gar.padaria.models.PlanosPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.gar.padaria.repositories.PlanosPagamentoRepository;

public interface PlanosPagamentoRepository extends JpaRepository<PlanosPagamento,Integer> {

}
