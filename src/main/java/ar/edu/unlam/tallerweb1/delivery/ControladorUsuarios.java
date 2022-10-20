package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorUsuarios {

    private ServicioLogin servicioLogin;

    @Autowired
    public ControladorUsuarios(ServicioLogin servicioLogin){
        this.servicioLogin = servicioLogin;
    }

    @RequestMapping(path = "/registrarme", method = RequestMethod.POST)
    public ModelAndView registrarUsuario(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro) {
        if(lasClavesNoCoinciden(datosRegistro.getClave(), datosRegistro.getRepiteClave())){
            ModelMap model = new ModelMap();
            model.put("error", "las claves no coinciden");
            model.put("datosRegistro", new DatosRegistro());
            return new ModelAndView("registrarme", model);
        }

        try {
            servicioLogin.registrar(datosRegistro.getUsuario(), datosRegistro.getClave());
        } catch (Exception e) {
            ModelMap model = new ModelMap();
            model.put("error", "El usuario ya existe");
            return new ModelAndView("registrarme", model);
        }
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping("/registrar-usuario")
    public ModelAndView irARegistrar() {
        ModelMap model = new ModelMap();
        model.put("datosRegistro", new DatosRegistro());
        return new ModelAndView("registrarme", model);
    }

    private static boolean lasClavesNoCoinciden(String clave, String repiteClave) {
        return !clave.equals(repiteClave);
    }


}
