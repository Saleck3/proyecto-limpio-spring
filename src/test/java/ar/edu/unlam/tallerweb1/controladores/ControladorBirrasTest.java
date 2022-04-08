package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ControladorBirrasTest {

    public static final String IPA = "IPA";
    public static final String VISTA_LISTADO_CERVEZAS = "listado-cervezas";
    public static final String TIPO_INVALIDO = "FRUTA";
    public static final String MENSAJE_TIPO_INVALIDO = "tipo inexistente";
    private ControladorBirras controladorBirras;
    @Test
    public void alPedirTodasLasBirrasDevuelveLaListaCompleta(){

        // preparacion
        dadoQuExistenCervezas(10, IPA);

        // ejecucion
        ModelAndView mav = cuandoBuscoCervezaDeTipo(IPA);

        // validacion
        entoncesEncuentro((List<Cerveza>) mav.getModel().get("cervezas"), 10);
        entoncesMeLLevaALaVista(VISTA_LISTADO_CERVEZAS, mav.getViewName());
    }

    @Test
    public void alPedirUnTipoInvalidoLlevaAPantallaDeError(){
        dadoQuExistenCervezas(10, IPA);

        ModelAndView mav = cuandoBuscoCervezaDeTipo(TIPO_INVALIDO);

        entoncesMeLLevaALaVista(VISTA_LISTADO_CERVEZAS, mav.getViewName());
        entoncesSeRecibeMensaje(MENSAJE_TIPO_INVALIDO, mav.getModel());
    }

    private ModelAndView cuandoBuscoCervezaDeTipo(String ipa) {
        return controladorBirras.listar(ipa);
    }

    private void entoncesSeRecibeMensaje(String mensaje, Map<String, Object> model) {
        assertThat(model.get("msg-error")).isEqualTo(mensaje);
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistaRecibida) {
        assertThat(vistaRecibida).isEqualTo(vistaEsperada);
    }

    private void entoncesEncuentro(List<Cerveza> lista, int cantidadEsperada) {
        assertThat(lista).hasSize(cantidadEsperada);
    }

    private void dadoQuExistenCervezas(int cantidadExistente, String tipo) {
        controladorBirras = new ControladorBirras(cantidadExistente, tipo);
    }
}
