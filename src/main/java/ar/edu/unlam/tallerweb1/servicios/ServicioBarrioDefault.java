package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBarrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ServicioBarrioDefault implements ServicioBarrio {

    private RepositorioBarrio repositorio;

    @Autowired
    public ServicioBarrioDefault(RepositorioBarrio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Direccion> direccionesDe(String barrio) {
        return null;
    }

    @Override
    public List<Direccion> buscarPorNombre(String barrio) {
        return repositorio.buscarPor(barrio);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void hacerTransferencia() {

    }
}
