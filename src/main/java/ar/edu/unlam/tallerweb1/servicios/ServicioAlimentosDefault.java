package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.Cerveza;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service @Transactional
public class ServicioAlimentosDefault implements ServicioAlimentos {

    @Override
    public List<Cerveza> buscarCervezasDelTipo(String tipo) {
        List<Cerveza> lista = new LinkedList<>();
        for(int i = 0 ; i < 3; i++){
            lista.add(new Cerveza(tipo));
        }
        return lista;
    }
}
