package ar.edu.unlam.tallerweb1.domain.figuritas;

import ar.edu.unlam.tallerweb1.delivery.DatosFiguritas;

import java.util.Map;

public interface ServicioFiguritasApi {

    Map<String, Map<Integer, String>> listar();
    Map<Integer, String> crear(Integer numero, String equipo);
}
