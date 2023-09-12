package br.com.gar.padaria.repositories;
import br.com.gar.padaria.models.Empresa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa,String> {

    List<Empresa> findAll();

    @Transactional
    void deleteByRazaoSocial(String razaoSocial); //somente fiquei com duvida se o metodo delete
                                                 // deve ser assim pela url ou pelo body JSON
}
