package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Calle;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

public class CallePersistenceTest extends SpringTest {

    @Test
    @Transactional @Rollback()
    public void creaUnaCalleYLaBuscaPorID(){
        Calle peru = new Calle();
        peru.setNombre("Peru");
        peru.setDobleMano(false);

        final Session session = session();
        session.save(peru);

        Calle buscada = session.get(Calle.class, peru.getId());
        assertThat(buscada).isNotNull();
    }

    @Test
    @Transactional @Rollback()
    public void modificaUnaCalleYLaBuscaPorID(){
        Calle peru = new Calle();
        peru.setNombre("Peru");
        peru.setDobleMano(false);
        final Session session = session();
        session.save(peru);
        peru.setDobleMano(true);

        session.update(peru);

        Calle buscada = session.get(Calle.class, peru.getId());
        assertThat(buscada.getDobleMano()).isTrue();
    }
}
