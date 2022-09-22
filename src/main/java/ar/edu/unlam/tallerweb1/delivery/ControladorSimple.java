package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorSimple {

	@RequestMapping(path = "/ir-a-pagina/nombre/{valor}", method = RequestMethod.GET)
	public ModelAndView irAPagina(@PathVariable String valor) {
		ModelMap model = new ModelMap();
		model.put("valor", valor);
		model.put("otro", "Otro valor");
		return new ModelAndView("pagina", model);

	}

	@RequestMapping(path = "/registrar", method = RequestMethod.POST)
	public ModelAndView registarPost(@ModelAttribute Producto producto) {
		ModelMap model = new ModelMap();
		model.put("nombre", producto.getNombre().toUpperCase());
		return new ModelAndView("agregado", model);

	}

	@RequestMapping(path = "/registrar", method = RequestMethod.GET)
	public ModelAndView registarGet() {
		ModelMap model = new ModelMap();
		Producto producto = new Producto();
		producto.setNombre("ingrese nombre de coducto");
		producto.setCodigo("COD001");
		model.put("producto", producto);
		return new ModelAndView("producto", model);

	}

}
