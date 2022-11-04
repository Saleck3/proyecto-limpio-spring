package ar.edu.unlam.tallerweb1.domain.figuritas;

import ar.edu.unlam.tallerweb1.delivery.DatosFiguritas;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServicioFiguritasApiImpl implements ServicioFiguritasApi {

    @Override
    public Map<String, Map<Integer, String>> listar() {
        return null;
    }

    @Override
    public Map<Integer, String> crear(Integer numero, String equipo) {
        return null;
    }
}
