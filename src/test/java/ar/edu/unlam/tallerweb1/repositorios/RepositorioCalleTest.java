package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Calle;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RepositorioCalleTest extends SpringTest {

    @Autowired
    private RepositorioCalle repositorioCalle;

    @Test @Transactional @Rollback
    public void busquedaDeCallePorNombre(){
        //preparacion
        Calle peru = new Calle();
        peru.setNombre("peru");
        session().save(peru);

        Calle peru2 = new Calle();
        peru2.setNombre("peru");
        session().save(peru2);

        Calle chile = new Calle();
        chile.setNombre("chile");
        session().save(chile);

        // ejecucion
        List<Calle> resultado = repositorioCalle.buscarPorNombre("peru");

        // validacion
        assertThat(resultado).hasSize(2);
    }

    @Test @Transactional @Rollback
    public void buscarCallesPorNombreDobleMano(){

        Calle peru = new Calle();
        peru.setNombre("peru");
        peru.setDobleMano(true);
        session().save(peru);

        Calle peru2 = new Calle();
        peru2.setNombre("peru");
        peru2.setDobleMano(false);
        session().save(peru2);

        // ejecucion
        List<Calle> resultado = repositorioCalle.buscarPorNombreYSentido("peru", true);

        // validacion
        assertThat(resultado).hasSize(1);
    }

    @Test @Transactional @Rollback
    public void buscarPorLike(){
        //preparacion
        Calle peru = new Calle();
        peru.setNombre("san martin");
        session().save(peru);

        Calle peru2 = new Calle();
        peru2.setNombre("san benito");
        session().save(peru2);

        Calle chile = new Calle();
        chile.setNombre("chile");
        session().save(chile);

        // ejecucion
        List<Calle> resultado = repositorioCalle.buscarPorNombreLike("san");

        // validacion
        assertThat(resultado).hasSize(2);
    }

    @Test @Transactional @Rollback
    public void guardarDireccion(){

        Direccion direccion = new Direccion();
        direccion.setAltura(1);
        direccion.setCalle("peru");
        direccion.setPiso(1);

        Barrio ramos = new Barrio();
        ramos.setNombre("ramos mejia");
        session().save(ramos);

        direccion.setBarrio(ramos);
        session().save(direccion);

        // por nombre del barrio
        List direcciones = session().createCriteria(Direccion.class)
                .createAlias("barrio", "b")
                .add(Restrictions.eq("b.nombre", "ramos mejia"))
                .list();
        assertThat(direcciones).hasSize(1);

        // por barrio, o sea por id de barrio
        direcciones = session().createCriteria(Direccion.class)
                .add(Restrictions.eq("barrio", ramos))
                .list();
        assertThat(direcciones).hasSize(1);
    }
}
