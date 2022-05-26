package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.UsuarioExistente;
import ar.edu.unlam.tallerweb1.servicios.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorUsuario {

    private UsuariosService usuariosService;

    @Autowired
    public ControladorUsuario(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @RequestMapping(path = "ir-a-registrarme")
    public ModelAndView irARegistrarme(){
        ModelMap model = new ModelMap();
        model.put("usuario", new DatosRegistro());
        return new ModelAndView("registro", model);
    }

    @RequestMapping(path = "registrarme", method = RequestMethod.POST)
    public ModelAndView registrarUsuario(@ModelAttribute DatosRegistro usuario) {
        ModelMap model = new ModelMap();
        String viewName = "registro";

        if(!usuario.getClave().equals(usuario.getRepiteClave())){
            model.put("mensaje", "Claves no coinciden");
            model.put("usuario", usuario);
            return new ModelAndView(viewName, model);
        }
        try {
            usuariosService.registrar(usuario.getEmail(), usuario.getClave());
            viewName = "home";
        } catch(UsuarioExistente e){
            model.put("mensaje", "Usuario ya existe");
            model.put("usuario", usuario);
        }
        return new ModelAndView(viewName, model);
    }
}
