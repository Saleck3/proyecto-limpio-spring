package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Inquilino;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioInquilinos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("ServicioInquilinos")
@Transactional
public class ServicioInquilinoImpl implements ServicioInquilinos{

    private RepositorioInquilinos repositorioInquilinos;

    @Autowired
    public ServicioInquilinoImpl(RepositorioInquilinos repositorioInquilinos){
        this.repositorioInquilinos = repositorioInquilinos;
    }

    @Override
    public Long crearInquilino(Inquilino inquilino) {
        return this.repositorioInquilinos.save(inquilino);
    }

    @Override
    public List<Inquilino> consultarInquilinos(){
        return this.repositorioInquilinos.findAll();
    }

    @Override
    public void borrarInquilino(Long id){
        this.repositorioInquilinos.delete(id);
        return;
    }
}
