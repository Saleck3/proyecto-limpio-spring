package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Calle;

import java.util.List;

public interface RepositorioCalle {
    List<Calle> buscarPorNombre(String nombre);

    List<Calle> buscarPorNombreYSentido(String nombre, boolean esDobleMano);

    List<Calle> buscarPorNombreLike(String nombre);
}
