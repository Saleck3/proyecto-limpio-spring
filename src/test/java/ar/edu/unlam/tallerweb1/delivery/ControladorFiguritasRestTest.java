package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.figuritas.ServicioFiguritasApi;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class ControladorFiguritasRestTest {
    public static final int NUMERO = 5;
    public static final String EQUIPO = "Argentina";
    private ControladorFiguritasApi controladorFiguritasApi;
    private ServicioFiguritasApi servicioFiguritasApi;

    @Before
    public void init(){
        this.servicioFiguritasApi = mock(ServicioFiguritasApi.class);
        this.controladorFiguritasApi = new ControladorFiguritasApi(this.servicioFiguritasApi);
    }

    @Test
    public void cuandoPidoListarFiguritasEntoncesReciboFiguritas(){
        dadoQueExistenFiguritas();
        ResponseEntity<Map<String, Map<Integer, String>>> equipos = cuandoListoFiguritas();
        entoncesObtengoUnaListaDeFiguritas(equipos);
    }

    @Test
    public void alInsertarUnEquipoObtengoUnCodigoDeExito(){
        dadoQuePuedoCrearUnEquipo();
        ResponseEntity<Map<Integer, String>> response = cuandoInsertoUnEquipo();
        entoncesObtengoUnEquipo(response, new DatosFiguritas(NUMERO, EQUIPO));
    }

    private void entoncesObtengoUnEquipo(ResponseEntity<Map<Integer, String>> equipo, DatosFiguritas equipoEsperado) {
        assertThat(equipo.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat( ((Map<Integer,String>)equipo.getBody()).get(equipoEsperado.getNumero())).isEqualTo(equipoEsperado.getEquipo());
    }

    private ResponseEntity<Map<Integer, String>> cuandoInsertoUnEquipo() {
        DatosFiguritas df = new DatosFiguritas(NUMERO, EQUIPO);
        return this.controladorFiguritasApi.crear(df);
    }

    private void dadoQuePuedoCrearUnEquipo(){
        Map<Integer, String> equipo = new HashMap<>();
        equipo.put(NUMERO, EQUIPO);
        when(this.servicioFiguritasApi.crear(anyInt(), anyString())).thenReturn(equipo);
    }

    private void entoncesObtengoUnaListaDeFiguritas(ResponseEntity<Map<String, Map<Integer, String>>> equipos) {
        assertThat(equipos.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(equipos.getBody()).hasSize(1);
        assertThat(equipos.getBody()).containsKey("equipos");
    }

    private ResponseEntity<Map<String, Map<Integer, String>>> cuandoListoFiguritas() {
        return this.controladorFiguritasApi.listar();
    }

    private void dadoQueExistenFiguritas() {
        Map<String, Map<Integer, String>> figuritas = new HashMap<>();
        figuritas.put("equipos", new HashMap<>());
        when(this.servicioFiguritasApi.listar()).thenReturn(figuritas);
    }
}
