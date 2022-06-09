package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioBarrio;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

public class ControladorBarrioTest {

    private  ControladorBarrio controlador;
    private ServicioBarrio servicioBarrio;
    private final String barrio = "ramos mejia";

    @Before
    public void init(){
        servicioBarrio = mock(ServicioBarrio.class);
        controlador = new ControladorBarrio(servicioBarrio);
    }

    @Test
    public void listarLasDireccionesDeUnBarrio(){

        List<Direccion> direcciones = new LinkedList<>();
        dadoUnBarrioConDirecciones(barrio, direcciones);

        List<Direccion> lista = cuandoListoLasDireccionesDe(barrio);

        entoncesObtengo(lista, direcciones.size());
    }

    private List<Direccion> cuandoListoLasDireccionesDe(String barrio) {

        ModelAndView mav = controlador.listarDirecciones(barrio);
        return (List<Direccion>) mav.getModel().get("direcciones");
    }

    private void dadoUnBarrioConDirecciones(String barrio, List<Direccion> direcciones) {
        when(servicioBarrio.direccionesDe(barrio)).thenReturn(direcciones);
    }

    private void entoncesObtengo(List<Direccion> lista, int size) {
        assertThat(lista).hasSize(size);
    }
}
