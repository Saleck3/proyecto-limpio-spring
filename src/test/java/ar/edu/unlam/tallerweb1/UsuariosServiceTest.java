package ar.edu.unlam.tallerweb1;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioNoExiste;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.MailService;
import ar.edu.unlam.tallerweb1.servicios.UsuariosService;
import ar.edu.unlam.tallerweb1.servicios.UsuariosServiceDefault;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class UsuariosServiceTest {

    private RepositorioUsuario repositorioUsuario;
    private UsuariosService servicioDeUsuarios;
    private MailService mailService;

    @Before
    public void init(){
        mailService = mock(MailService.class);
        repositorioUsuario = mock(RepositorioUsuario.class);
        servicioDeUsuarios = new UsuariosServiceDefault(repositorioUsuario, mailService);
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

    private void entoncesSeEnviaElMailDeReset() {
        verify(mailService, times(1)).enviarResetClave("seba@seba.com");
    }

    private void entoncesObtengoUnError() {
        verify(mailService, never()).enviarResetClave(anyString());
    }

    private void dadoQueNoExisteElUsuario(String usuario) {
        when(repositorioUsuario.buscar(usuario)).thenReturn(null);
    }

    private void dadoQueExisteElUsuario(String usuario) {
        when(repositorioUsuario.buscar(usuario)).thenReturn(new Usuario());
    }

    private void cuandoQuieroRestablecerLaContraseniaDe(String usuario) {
        servicioDeUsuarios.restablecerContrasenia(usuario);
    }
}
