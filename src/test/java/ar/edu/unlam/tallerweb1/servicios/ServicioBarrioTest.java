package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBarrio;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioBarrioTest {

    private ServicioBarrio servicio;
    private RepositorioBarrio repositorio;

    @Before
    public void init(){
        repositorio = mock(RepositorioBarrio.class);
        servicio = new ServicioBarrioDefault(repositorio);
    }

    @Test
    public void buscarLasDireccionesDeUnBarrio(){
        Set<Direccion> direcciones = new HashSet<>();
        dadoUnBarrioConDirecciones("ramos mejia", direcciones);

        Barrio ramos = cuandoBuscoElBarrio("ramos mejia");

        entoncesObtengo(ramos.getLugares(), direcciones.size());
    }

    private void dadoUnBarrioConDirecciones(String nombre, Set<Direccion> direcciones) {

        Barrio barrio = mock(Barrio.class);
        when(barrio.getLugares()).thenReturn(direcciones);
        when(repositorio.buscarPor(nombre)).thenReturn(barrio);
    }

    private Barrio cuandoBuscoElBarrio(String barrio) {
        return servicio.buscarPorNombre(barrio);
    }

    private void entoncesObtengo(Collection lista, int size) {
        assertThat(lista).hasSize(size);
    }

}
