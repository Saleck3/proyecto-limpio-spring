package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

public class RepositorioUsuarioDeberia extends SpringTest {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Test @Transactional @Rollback
    public void noDevolverResultadosSiBuscoConUnMailQueNoExiste(){

        dadoQueNoExisteUnUsuarioConMail("seba@seba.com");

        Usuario usuario = repositorioUsuario.buscar("seba@seba.com");

        entoncesUsuarioNoEncontrado(usuario);
    }

    @Test @Transactional @Rollback
    public void devolverElUsuarioQueCoincidaConElMail(){
        dadoQueExisteUnUsuarioConMail("seba@seba.com");

        Usuario usuario = repositorioUsuario.buscar("seba@seba.com");

        entoncesUsuarioEncontrado(usuario);
    }

    @Test @Transactional @Rollback
    public void guardarUnUsuario(){
        cuandoGuardoUnUsuarioConMail("seba@seba.com");

        entoncesSeCreaElUsuarioConMail("seba@seba.com");
    }

    private void cuandoGuardoUnUsuarioConMail(String email) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        repositorioUsuario.guardar(usuario);
    }

    private void entoncesSeCreaElUsuarioConMail(String email) {
        assertThat(repositorioUsuario.buscar(email)).isNotNull();
    }

    private void dadoQueExisteUnUsuarioConMail(String mail) {
        Usuario usuario = new Usuario();
        usuario.setEmail(mail);
        session().save(usuario);
    }

    private void dadoQueNoExisteUnUsuarioConMail(String mail) {
    }

    private void entoncesUsuarioEncontrado(Usuario usuario) {
        assertThat(usuario).isNotNull();
    }

    private void entoncesUsuarioNoEncontrado(Usuario usuario) {
        assertThat(usuario).isNull();
    }
}
