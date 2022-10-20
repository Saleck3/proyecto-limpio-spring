package ar.edu.unlam.tallerweb1.domain.kata;

import ar.edu.unlam.tallerweb1.domain.usuarios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLoginImpl;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.junit.Test;
import org.junit.Before;

import static org.mockito.Mockito.*;

public class ServicioLoginDeberia {

    private ServicioLogin servicioLogin;
    private RepositorioUsuario repositorioUsuario;

    @Before
    public void init(){
        repositorioUsuario = mock(RepositorioUsuario.class);
        servicioLogin = new ServicioLoginImpl(repositorioUsuario);
    }

    @Test
    public void guardarElNuevoUsuarioSiElRegistroEsExitoso(){

        cuandoRegistroElUsuario("seba@seba.com", "1234");

        entoncesSeGuardaElUsuario("seba@seba.com", "1234");
    }

    private void entoncesSeGuardaElUsuario(String usuario, String clave) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setEmail(usuario);
        nuevoUsuario.setPassword(clave);

        verify(repositorioUsuario).guardar(any(Usuario.class));
        // ArgumentMatchers
    }

    private void cuandoRegistroElUsuario(String usuario, String clave) {
        servicioLogin.registrar(usuario, clave);
    }
}
