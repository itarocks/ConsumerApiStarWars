import br.com.amedigital.repository.PlanetRepository;
import br.com.amedigital.util.JPAUtil;

import javax.persistence.EntityManager;

public class PlanetaTest {

    public static void main(String[] args) {


        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        PlanetRepository teste = new PlanetRepository();

        System.out.println("Valores da tabela" + teste.findAll());
        em.getTransaction().commit();
    }
}


