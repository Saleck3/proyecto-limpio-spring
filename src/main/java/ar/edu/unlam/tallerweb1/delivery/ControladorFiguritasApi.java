package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.figuritas.ServicioFiguritasApi;
import ar.edu.unlam.tallerweb1.domain.figuritas.ServicioFiguritasApiImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ControladorFiguritasApi {

    private ServicioFiguritasApi servicioFiguritasApi;

    @Autowired
    public ControladorFiguritasApi(ServicioFiguritasApi servicioFiguritasApi) {
        this.servicioFiguritasApi = servicioFiguritasApi;
    }

    @RequestMapping(path="equipos", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Map<Integer, String>>> listar() {
        return ResponseEntity.ok(this.servicioFiguritasApi.listar());
    }

    @RequestMapping(path = "equipos", method = RequestMethod.POST)
    public ResponseEntity<Map<Integer, String>> crear(@RequestBody DatosFiguritas datosFiguritas) {
        Map<Integer,String> equipo = this.servicioFiguritasApi.crear(datosFiguritas.getNumero(), datosFiguritas.getEquipo());
        return ResponseEntity.ok(equipo);
    }
}
