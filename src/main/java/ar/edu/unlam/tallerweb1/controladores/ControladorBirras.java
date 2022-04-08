package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ControladorBirras {
    // TODO solo para explicar controladores, hay que eliminarlo!!!!!
    private List<Cerveza> lista = new LinkedList<>();
    public ControladorBirras(int cantidadExistente, String tipo) {
        for (int i = 0; i < cantidadExistente; i++)
            lista.add(new Cerveza(tipo));
    }
    // TODO solo para explicar controladores, hay que eliminarlo!!!!!

    // /listarCerveza GET
    public ModelAndView listar(String tipo) {
        ModelMap model = new ModelMap();
        List<Cerveza> resultado = buscarCervezasDelTipo(tipo);

        if(resultado.isEmpty()){
            model.put("msg-error", "tipo inexistente");
        } else {
            model.put("cervezas", resultado);
        }
        return new ModelAndView("listado-cervezas", model);
    }

    private List<Cerveza> buscarCervezasDelTipo(String tipo) {
        List<Cerveza> resultado = new ArrayList<>();
        for(Cerveza each: lista){
            if(each.getTipo().equals(tipo))
                resultado.add(each);
        }
        return resultado;
    }
}
