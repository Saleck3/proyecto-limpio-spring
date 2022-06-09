package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

public class BarrioTest extends SpringTest {

    @Test @Transactional @Rollback
    public void guardarBarrioConLugares(){
        Barrio ramos = new Barrio();
        ramos.setNombre("Ramos Mejia");

        Direccion d1 = new Direccion();
        d1.setCalle("Peru");
        ramos.agregar(d1);

        Direccion d2 = new Direccion();
        d2.setCalle("Chile");
        ramos.agregar(d2);

        session().save(ramos);

        final Barrio barrio = session().get(Barrio.class, ramos.getId());

        assertThat(barrio.getLugares()).hasSize(2);
    }
}
