package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioBarrioTest extends SpringTest {

    Barrio ramos = new Barrio();
    @Autowired
    private RepositorioBarrio repositorioBarrio;

    @Test @Transactional @Rollback
    public void buscarPorNombre(){
        dadoUnBarrioConDirecciones();

        Barrio buscado = cuandoBuscoPorNombre(ramos.getNombre());

        entoncesEncuentro(buscado.getLugares(), ramos.getLugares().size());
    }

    private void entoncesEncuentro(Set<Direccion> lugares, int size) {
        assertThat(lugares).hasSize(size);
    }

    private Barrio cuandoBuscoPorNombre(String nombre) {
        return repositorioBarrio.buscarPor(nombre);
    }

    private void dadoUnBarrioConDirecciones() {

        ramos.setNombre("Ramos Mejia");

        Direccion d1 = new Direccion();
        d1.setCalle("Peru");
        ramos.agregar(d1);

        Direccion d2 = new Direccion();
        d2.setCalle("Chile");
        ramos.agregar(d2);

        session().save(ramos);
    }
}
