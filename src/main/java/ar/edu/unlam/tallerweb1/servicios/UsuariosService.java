package ar.edu.unlam.tallerweb1.servicios;

public interface UsuariosService {
    void restablecerContrasenia(String usuario);
    void registrar(String mail, String clave);
}
