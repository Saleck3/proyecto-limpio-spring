package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioAlimentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorBirras {

    private ServicioAlimentos servicioAlimentos;

    @Autowired
    public  ControladorBirras(ServicioAlimentos servicioAlimentos){
        this.servicioAlimentos = servicioAlimentos;
    }

    @RequestMapping(path="/listar-birras/{tipo}")
    public ModelAndView listar(@PathVariable("tipo") String tipo) {
        ModelMap model = new ModelMap();
        List<Cerveza> resultado = null;
        try{
            resultado = servicioAlimentos.buscarCervezasDelTipo(tipo);
        } catch(Exception e) {
            model.put("msg-error", "tipo inexistente");
        }
        model.put("cervezas", resultado);
        return new ModelAndView("listado-cervezas", model);
    }

}
