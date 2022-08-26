package ar.edu.unlam.tallerweb1.delivery;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculadoraDeCadenaTest {

    @Test(expected = RuntimeException.class)
    public void DebeLanzarUnaExceptionSiRecibeUnaCadenaVacia(){

        //Preparacion
        CalculadoraDeCadena calculadoraDeCadena = DadoQueTenemosUnaCalculadora();

        //Ejecucion
        Long resultado = CuandoRealizamosLaOperacionSumar(calculadoraDeCadena, "");

        //Validacion
    }

    @Test
    public void DebeDevolver4SiRecibe2Y2(){
        CalculadoraDeCadena calculadoraDeCadena = DadoQueTenemosUnaCalculadora();
        Long resultado = CuandoRealizamosLaOperacionSumar(calculadoraDeCadena, "2,2");
        EntoncesReciboElResultado(resultado, 4L);
    }

    @Test
    public void DebeDevolver6SiRecibe3Y3(){
        CalculadoraDeCadena calculadoraDeCadena = DadoQueTenemosUnaCalculadora();
        Long resultado = CuandoRealizamosLaOperacionSumar(calculadoraDeCadena, "3,3");
        EntoncesReciboElResultado(resultado, 6L);
    }

    private void EntoncesReciboElResultado(Long resultadoObtenido, Long resultadoEsperado) {
        assertThat(resultadoObtenido).isEqualTo(resultadoEsperado);
    }

    private Long CuandoRealizamosLaOperacionSumar(CalculadoraDeCadena calculadoraDeCadena, String cadena) {
        return calculadoraDeCadena.sumar(cadena);
    }

    private CalculadoraDeCadena DadoQueTenemosUnaCalculadora() {
        return new CalculadoraDeCadena();
    }
}
