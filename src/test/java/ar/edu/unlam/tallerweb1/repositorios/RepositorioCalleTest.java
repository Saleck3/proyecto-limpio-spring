package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Calle;
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
}
