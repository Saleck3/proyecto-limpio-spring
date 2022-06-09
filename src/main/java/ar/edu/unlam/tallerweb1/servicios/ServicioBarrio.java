package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Direccion;

import java.util.List;

public interface ServicioBarrio {
    List<Direccion> direccionesDe(String barrio);

    List<Direccion> buscarPorNombre(String barrio);

    void hacerTransferencia();
}
