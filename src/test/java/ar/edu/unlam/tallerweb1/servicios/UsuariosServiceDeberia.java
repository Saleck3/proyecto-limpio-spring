package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.UsuarioNoExiste;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class UsuariosServiceDeberia {

    private RepositorioUsuario repositorioUsuario;
    private UsuariosService servicioDeUsuarios;
    private MailService mailService;

    @Before
    public void init(){
        mailService = mock(MailService.class);
        repositorioUsuario = mock(RepositorioUsuario.class);
        servicioDeUsuarios = new UsuariosServiceDefault(repositorioUsuario, mailService);
    }

    @Test(expected = UsuarioExistente.class)
    public void lanzarExcepcionAlRegistrarUsuarioSiYaExiste(){
        dadoQueExisteUnUsuarioConMail("seba@seba.com");

        cuandoRegistroUsuario("seba@seba.com", "");

        validarNoCreacionDeUsuario("seba@seba.com");
    }

    @Test
    public void guardarElUsuarioNuevoSiNoExiste(){
        dadoQueNoExisteUnUsuarioConMail("seba@seba.com");

        cuandoRegistroUsuario("seba@seba.com", "");

        entoncesSeGuardaUnUsuarioConMail("seba@seba.com");
    }

    @Test
    public void enviarMailDeActivarCuenta(){
        dadoQueNoExisteUnUsuarioConMail("seba@seba.com");

        cuandoRegistroUsuario("seba@seba.com", "");

        entoncesSeEnviaMailDeActivarCuenta("seba@seba.com");
    }


    @Test(expected = UsuarioNoExiste.class)
    public void restablecerContraseniaDeUsuarioExistenteDeberiaDarError(){
        dadoQueNoExisteElUsuario("seba@seba.com");

        cuandoQuieroRestablecerLaContraseniaDe("seba@seba.com");

        entoncesObtengoUnError();
    }

    @Test
    public void restablecerContraseniaDeUsuarioExistenter(){
        dadoQueExisteElUsuario("seba@seba.com");

        cuandoQuieroRestablecerLaContraseniaDe("seba@seba.com");

        entoncesSeEnviaElMailDeReset();
    }

    private void dadoQueExisteUnUsuarioConMail(String mail) {
        when(repositorioUsuario.buscar(mail)).thenReturn(new Usuario());
    }

    private void dadoQueNoExisteElUsuario(String usuario) {
        when(repositorioUsuario.buscar(usuario)).thenReturn(null);
    }

    private void dadoQueNoExisteUnUsuarioConMail(String mail) {
        when(repositorioUsuario.buscar(mail)).thenReturn(null);
    }

    private void dadoQueExisteElUsuario(String usuario) {
        when(repositorioUsuario.buscar(usuario)).thenReturn(new Usuario());
    }

    private void cuandoQuieroRestablecerLaContraseniaDe(String usuario) {
        servicioDeUsuarios.restablecerContrasenia(usuario);
    }
    private void cuandoRegistroUsuario(String mail, String clave) {
        servicioDeUsuarios.registrar(mail, clave);
    }

    private void entoncesSeEnviaElMailDeReset() {
        verify(mailService, times(1)).enviarResetClave("seba@seba.com");
    }

    private void entoncesObtengoUnError() {
        verify(mailService, never()).enviarResetClave(anyString());
    }

    private void entoncesSeGuardaUnUsuarioConMail(String mail) {
        // argument validator
        verify(repositorioUsuario, times(1)).guardar(any(Usuario.class));
    }

    private void entoncesSeEnviaMailDeActivarCuenta(String mail) {
        verify(mailService, times(1)).enviarMailActivarCuenta(mail);
    }

    private void validarNoCreacionDeUsuario(String mail) {
        verify(repositorioUsuario, never()).guardar(any(Usuario.class));
        verify(mailService, never()).enviarMailActivarCuenta(mail);
    }
}
