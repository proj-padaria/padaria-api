package br.com.gar.padaria.repositories;
import br.com.gar.padaria.models.Uf;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UfRepository extends JpaRepository<Uf, Integer> {
    Uf findBySiglaIgnoreCase(String sigla);

}
