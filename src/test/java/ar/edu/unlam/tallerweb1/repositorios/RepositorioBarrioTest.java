package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioBarrioTest extends SpringTest {

    Barrio ramos = new Barrio();
    @Autowired
    private RepositorioBarrio repositorioBarrio;

    @Test @Transactional @Rollback
    public void buscarPorNombre(){
        dadoUnBarrioConDirecciones();

        final List<Direccion> direccions = cuandoBuscoPorNombre(ramos.getNombre());

        entoncesEncuentro(direccions, 2);
    }

    private void entoncesEncuentro(List<Direccion> lugares, int size) {
        assertThat(lugares).hasSize(size);
    }

    private List<Direccion> cuandoBuscoPorNombre(String nombre) {
        return repositorioBarrio.buscarPor(nombre);
    }

    private void dadoUnBarrioConDirecciones() {

        ramos = new Barrio();
        ramos.setNombre("haedo");
        session().save(ramos);

        Direccion d1 = new Direccion();
        d1.setCalle("Peru");
        d1.setBarrio(ramos);
        session().save(d1);

        Direccion d2 = new Direccion();
        d2.setCalle("Chile");
        d2.setBarrio(ramos);
        session().save(d2);
    }
}
