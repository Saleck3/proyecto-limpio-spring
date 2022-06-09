package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Direccion;

import java.util.List;

public interface RepositorioBarrio {
    List<Direccion> buscarPor(String nombre);
}
