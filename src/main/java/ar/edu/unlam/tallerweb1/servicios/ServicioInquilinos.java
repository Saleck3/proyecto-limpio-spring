package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Inquilino;
import java.util.List;

public interface ServicioInquilinos {
    public Long crearInquilino(Inquilino inquilino);
    public List<Inquilino> consultarInquilinos();
}
