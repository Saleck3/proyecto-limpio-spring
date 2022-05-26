package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.UsuarioExistente;
import ar.edu.unlam.tallerweb1.servicios.UsuariosService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorUsuariosDeberia {

    private ControladorUsuario controlador;
    private UsuariosService usuariosService;

    @Before
    public void init(){
        usuariosService = mock(UsuariosService.class);
        controlador = new ControladorUsuario(usuariosService);
    }

    @Test
    public void retornarErrorAlRegistrarUnUsuarioConUnMailExistente(){
        dadoQueExisteUnUsuarioConMail("usuario@usuario.com", "");

        ModelAndView mav = cuandoRegistroUnUsuarioConMail("usuario@usuario.com", "", "");

        entoncesRegresoALaVistaDeRegistroConMensaje("Usuario ya existe", mav);
    }

    @Test
    public void retornarErrorAlRegistrarUnUsuarioConClavesQueNoCoinciden(){
        ModelAndView mav = cuandoRegistroUnUsuarioConMail("usuario@usuario.com", "123", "234");

        entoncesRegresoALaVistaDeRegistroConMensaje("Claves no coinciden", mav);
    }

    @Test
    public void llevarAlHomeSiElRegistroEsExitoso(){
        dadoQueNoExisteUnUsuarioConMail("usuario@usuario.com");

        ModelAndView mav = cuandoRegistroUnUsuarioConMail("usuario@usuario.com", "123", "123");

        entoncesRedirigerAlHome(mav);
    }

    private void dadoQueNoExisteUnUsuarioConMail(String email) {
    }

    private void dadoQueExisteUnUsuarioConMail(String mail, String clave) {
        doThrow(UsuarioExistente.class).when(usuariosService).registrar(mail, clave);
    }

    private ModelAndView cuandoRegistroUnUsuarioConMail(String mail, String clave, String repiteClave) {
        DatosRegistro datos = new DatosRegistro();
        datos.setClave(clave);
        datos.setEmail(mail);
        datos.setRepiteClave(repiteClave);
        return controlador.registrarUsuario(datos);
    }

    private void entoncesRedirigerAlHome(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
    }

    private void entoncesRegresoALaVistaDeRegistroConMensaje(String mensaje, ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registro");
        assertThat(mav.getModel().get("mensaje")).isEqualTo(mensaje);
    }
}
