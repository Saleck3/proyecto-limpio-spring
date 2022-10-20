package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


public class ControladorUsuariosDeberia {

    private ControladorUsuarios controladorUsuarios;
    private ServicioLogin servicioLogin;

    @Before
    public void init(){
        servicioLogin = mock(ServicioLogin.class);
        controladorUsuarios = new ControladorUsuarios(servicioLogin);
    }

    @Test
    public void redirigirmeAlLoginSiElRegistroEsExitoso(){
        
        String vista = cuandoRegistroElUsuario("seba@seba.com");
        
        entoncesMeRedirigeAlLogin(vista, "login");
    }

    @Test
    public void darErrorAlRegistrarUnUsuarioExistente(){
        dadoQueExisteElUsuario("lionel@messi.com");

        String vista = cuandoRegistroElUsuario("lionel@messi.com");

        entoncesMeRedirigeAlLogin(vista, "registrarme");
    }

    private void dadoQueExisteElUsuario(String usuario) {
        doThrow(Exception.class).when(servicioLogin).registrar(usuario);
    }

    private void entoncesMeRedirigeAlLogin(String vista, String vistaEsperada) {
        assertThat(vista).isEqualTo(vistaEsperada);
    }

    private String cuandoRegistroElUsuario(String usuario) {
        ModelAndView mav = controladorUsuarios.registrarUsuario(usuario);
        return mav.getViewName();
    }
}
