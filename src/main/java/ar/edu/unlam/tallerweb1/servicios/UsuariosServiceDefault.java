package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioExistente;
import ar.edu.unlam.tallerweb1.modelo.UsuarioNoExiste;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class UsuariosServiceDefault implements UsuariosService {
    private RepositorioUsuario repositorioUsuario;
    private MailService mailService;

    @Autowired
    public UsuariosServiceDefault(RepositorioUsuario repositorioUsuario, MailService mailService) {
        this.repositorioUsuario = repositorioUsuario;
        this.mailService = mailService;
    }

    @Override
    public void restablecerContrasenia(String usuario) {
        Usuario encontrado = repositorioUsuario.buscar(usuario);
        if(encontrado==null)
            throw new UsuarioNoExiste();

        mailService.enviarResetClave(usuario);
    }

    @Override
    public void registrar(String mail, String clave) {
        final Usuario usuario = repositorioUsuario.buscar(mail);
        if(usuario != null) throw new UsuarioExistente();

        Usuario nuevo = new Usuario();
        nuevo.setEmail(mail);
        nuevo.setPassword(clave);
        repositorioUsuario.guardar(nuevo);
        mailService.enviarMailActivarCuenta(mail);
    }
}
