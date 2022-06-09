package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioBarrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorBarrio {
    private ServicioBarrio servicioBarrio;

    @Autowired
    public ControladorBarrio(ServicioBarrio servicioBarrio) {
        this.servicioBarrio = servicioBarrio;
    }

    @RequestMapping(path="/listar-direcciones/{barrio}")
    public ModelAndView listarDirecciones(@PathVariable("barrio") String barrio) {
        ModelMap model = new ModelMap();
        model.put("direcciones", servicioBarrio.buscarPorNombre(barrio));
        return new ModelAndView("lista-direcciones", model);
    }
}
