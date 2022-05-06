package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioAlimentos;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorBirrasTest {

    public static final String IPA = "IPA";
    public static final String VISTA_LISTADO_CERVEZAS = "listado-cervezas";
    public static final String TIPO_INVALIDO = "FRUTA";
    public static final String MENSAJE_TIPO_INVALIDO = "tipo inexistente";
    private ControladorBirras controladorBirras;
    private ServicioAlimentos servicioAlimentos;

    @Before
    public void init(){
        servicioAlimentos = mock(ServicioAlimentos.class);
        controladorBirras = new ControladorBirras(servicioAlimentos);
    }

    @Test
    public void alPedirTodasLasBirrasDevuelveLaListaCompleta(){

        dadoQueExistenCervezas(10, IPA);

        ModelAndView mav = cuandoBuscoCervezaDeTipo(IPA);

        entoncesEncuentro(mav, 10);
        entoncesMeLLevaALaVista(VISTA_LISTADO_CERVEZAS, mav.getViewName());
    }

    @Test
    public void alPedirUnTipoInvalidoLlevaAPantallaDeError(){
        when(servicioAlimentos.buscarCervezasDelTipo(TIPO_INVALIDO)).thenThrow(new RuntimeException());

        ModelAndView mav = cuandoBuscoCervezaDeTipo(TIPO_INVALIDO);

        entoncesMeLLevaALaVista(VISTA_LISTADO_CERVEZAS, mav.getViewName());
        entoncesSeRecibeMensaje(MENSAJE_TIPO_INVALIDO, mav.getModel());
    }

    private void dadoQueExistenCervezas(int cantidad, String tipo) {
        List<Cerveza> lista = new LinkedList<>();
        for(int i = 0 ; i < cantidad; i++){
            lista.add(new Cerveza(tipo));
        }
        when(servicioAlimentos.buscarCervezasDelTipo(tipo)).thenReturn(lista);
    }

    private ModelAndView cuandoBuscoCervezaDeTipo(String tipo) {
        return controladorBirras.listar(tipo);
    }

    private void entoncesSeRecibeMensaje(String mensaje, Map<String, Object> model) {
        assertThat(model.get("msg-error")).isEqualTo(mensaje);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistaRecibida) {
        assertThat(vistaRecibida).isEqualTo(vistaEsperada);
    }

    private void entoncesEncuentro(ModelAndView mav, int cantidadEsperada) {
        List<Cerveza> lista = (List<Cerveza>) mav.getModel().get("cervezas");
        assertThat(lista).hasSize(cantidadEsperada);
    }
}
