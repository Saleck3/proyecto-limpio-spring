package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioFarmaciaTest extends SpringTest {
    @Autowired
    private RepositorioFarmacia repositorioFarmacia;

    @Test @Transactional @Rollback
    public void buscarFarmaciaPorCalle(){

        Farmacia f1 = new Farmacia();
        f1.setNombre("Para Ti");
        Direccion d1 = new Direccion();
        d1.setCalle("peru");
        d1.setAltura(1022);
        f1.setDireccion(d1);

        Farmacia f2 = new Farmacia();
        f2.setNombre("Farmacity");
        Direccion d2 = new Direccion();
        d2.setCalle("peru");
        d2.setAltura(1);
        f2.setDireccion(d2);

        Farmacia f3 = new Farmacia();
        f3.setNombre("Dr Ahorro");
        Direccion d3 = new Direccion();
        d3.setCalle("chile");
        d3.setAltura(99);
        f3.setDireccion(d3);

        session().save(f1);
        session().save(f2);
        session().save(f3);

        List<Farmacia> lista = repositorioFarmacia.buscarPorNombreDeCalle("peru");

        assertThat(lista).hasSize(2);

    }
}
