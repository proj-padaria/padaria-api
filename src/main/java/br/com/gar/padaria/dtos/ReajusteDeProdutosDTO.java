package br.com.gar.padaria.dtos;

import jakarta.persistence.*;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

import java.io.Serializable;
/*
@Entity
@NamedStoredProcedureQuery(
        name = "f_reajuste_preco_venda",
        procedureName = "f_reajuste_preco_venda",
        parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "nome"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "preco_venda"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "precoReajustado")}

)

 */
public class ProdutoDTO implements Serializable {
    private static final long serialVersion = 1L;
/*
    private String nome;

    private Double precoVenda;

    private EntityManagerFactory emf;

    @Before()
    public void init() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unity");
    }

    @After
    public void close() {
        emf.close();
    }

    @Teste
    public void f_reajuste_preco_venda() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        StoredProcedureQuery query = em.createStoredProcedureQuery("f_reajuste_preco_venda");
        query.setParameter("nome", nome);
        query.setParameter("preco_venda", precoVenda);
        query.execute();
        Double precoReajustado = (Double) query.getOutputParameterValue("precoReajustado");
        log.info(precoReajustado);

        em.getTransaction().commit();
        em.close();


    }

 */
}
