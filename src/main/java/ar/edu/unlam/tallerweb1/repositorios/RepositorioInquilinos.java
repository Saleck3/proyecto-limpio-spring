package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Inquilino;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RepositorioInquilinos {
    public List<Inquilino> findAll();
    public Long save(Inquilino inquilino);
    public void delete(Long id);
}
