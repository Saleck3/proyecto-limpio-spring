package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.Cerveza;
import java.util.List;

public interface ServicioAlimentos {
    List<Cerveza> buscarCervezasDelTipo(String tipo);
}
