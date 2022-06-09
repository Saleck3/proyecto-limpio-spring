package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBarrio;

import java.util.List;

public class ServicioBarrioDefault implements ServicioBarrio {


    private RepositorioBarrio repositorio;

    public ServicioBarrioDefault(RepositorioBarrio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Direccion> direccionesDe(String barrio) {
        return null;
    }

    @Override
    public Barrio buscarPorNombre(String barrio) {
        return repositorio.buscarPor(barrio);
    }
}
