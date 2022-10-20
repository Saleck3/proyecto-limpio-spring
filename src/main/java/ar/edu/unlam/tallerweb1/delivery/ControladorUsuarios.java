package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import org.springframework.web.servlet.ModelAndView;

public class ControladorUsuarios {

    private final ServicioLogin servicioLogin;

    public ControladorUsuarios(ServicioLogin servicioLogin){
        this.servicioLogin = servicioLogin;
    }

    public ModelAndView registrarUsuario(DatosRegistro datosRegistro) {
        if(lasClavesNoCoinciden(datosRegistro.getClave(), datosRegistro.getRepiteClave()))
            return new ModelAndView("registrarme");
        try {
            servicioLogin.registrar(datosRegistro.getUsuario(), datosRegistro.getClave());
        } catch (Exception e) {
            return new ModelAndView("registrarme");
        }
        return new ModelAndView("login");
    }

    private static boolean lasClavesNoCoinciden(String clave, String repiteClave) {
        return !clave.equals(repiteClave);
    }


}
