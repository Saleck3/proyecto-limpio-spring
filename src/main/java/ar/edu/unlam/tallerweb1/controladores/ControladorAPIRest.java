package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Inquilino;
import ar.edu.unlam.tallerweb1.servicios.ServicioInquilinos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorAPIRest {

    private ServicioInquilinos servicioInquilinos;

    @Autowired
    public ControladorAPIRest(ServicioInquilinos servicioInquilinos){
        this.servicioInquilinos = servicioInquilinos;
    }

    @RequestMapping(path = "/inquilinos", method = RequestMethod.GET)
    public ResponseEntity<List<Inquilino>> ObtenerInquilinos(){
        List<Inquilino> inquilinos = this.servicioInquilinos.consultarInquilinos();
        return ResponseEntity.status(HttpStatus.OK).body(inquilinos);
    }

    @RequestMapping(path = "/inquilinos", method = RequestMethod.POST)
    public ResponseEntity GuardarInquilinos(@RequestBody List<Inquilino> inquilinos){
        for (Inquilino inquilino: inquilinos) {
            this.servicioInquilinos.crearInquilino(inquilino);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/inquilinos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity EliminarInquilinos(@PathVariable("id") Long id){
        this.servicioInquilinos.borrarInquilino(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
