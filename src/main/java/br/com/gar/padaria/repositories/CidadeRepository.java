package br.com.gar.padaria.repositories;
import br.com.gar.padaria.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade,Integer>  {
    List<Cidade> findAll();


}
