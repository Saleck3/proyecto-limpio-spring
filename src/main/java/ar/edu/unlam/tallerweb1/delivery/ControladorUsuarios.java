package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import org.springframework.web.servlet.ModelAndView;

public class ControladorUsuarios {

    private final ServicioLogin servicioLogin;

    public ControladorUsuarios(ServicioLogin servicioLogin){
        this.servicioLogin = servicioLogin;
    }
    public ModelAndView registrarUsuario(String usuario) {
        try {
            servicioLogin.registrar(usuario);
        } catch (Exception e){
            return new ModelAndView("registrarme");
        }
        return new ModelAndView("login");
    }
}
