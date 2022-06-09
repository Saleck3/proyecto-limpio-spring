package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioBarrio;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;


public class ControladorBarrio {
    private ServicioBarrio servicioBarrio;

    public ControladorBarrio(ServicioBarrio servicioBarrio) {

        this.servicioBarrio = servicioBarrio;
    }

    public ModelAndView listarDirecciones(String barrio) {
        ModelMap model = new ModelMap();
        model.put("direcciones", servicioBarrio.direccionesDe(barrio));
        return new ModelAndView("lista-direcciones", model);
    }
}
