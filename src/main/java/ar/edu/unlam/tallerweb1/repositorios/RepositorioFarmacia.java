package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;

import java.util.List;

public interface RepositorioFarmacia {
    List<Farmacia> buscarPorNombreDeCalle(String peru);
}
