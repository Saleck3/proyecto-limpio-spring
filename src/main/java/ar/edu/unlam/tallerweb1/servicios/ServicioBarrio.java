package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;

import java.util.List;

public interface ServicioBarrio {
    List<Direccion> direccionesDe(String barrio);

    Barrio buscarPorNombre(String barrio);
}
