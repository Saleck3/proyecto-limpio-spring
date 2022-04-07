package ar.edu.unlam.tallerweb1.tdd;
// Tdd by Example.... author: kent beck
// CLEAN CODE  uncle bob

// 1 no esribir codigo productivo sin que haya un test que falle antes
// 2 escbir el menor codigo productivo posile que haga que mi test pase
// 3 mejorar el codigo hecho (REFACTOR)
// BABY STEPS

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CajaFuerteTest {

    private Integer clave = 4657;
    private CajaFuerte cajaFuerte = new CajaFuerte();
    private Integer claveErronea = 8888;

    @Test
    public void alAbrirConClaveCorrectaDeberiaAbrirse(){ // QUE

        // preparacion
        cajaFuerte.cerrarCon(clave);
        // ejecucion
        cajaFuerte.abrirCon(clave);
        // validacion (esperado vs real)
        entoncesEstaAbiertaLa(cajaFuerte);
    }

    @Test
    public void alAbrirConClaveIncorrectaNODeberiaAbrirse(){
        // preparacion
        cajaFuerte.cerrarCon(clave);
        // ejecucion
        cajaFuerte.abrirCon(claveErronea);
        // validacion (esperado vs real)
        entoncesEstaCerradaLa(cajaFuerte);
    }

    @Test
    public void alCrearUnaCajaFuerteDeberiaEstarAbierta(){
        //validacion
        entoncesEstaAbiertaLa(cajaFuerte);
    }

    @Test
    public void alCerrarUnaCajaFuerteDeberiaQuedarCerrada(){
        cajaFuerte.cerrarCon(clave);
        entoncesEstaCerradaLa(cajaFuerte);
    }

    @Test
    public void alCambiarDeClaveDeberiaAbrirseConLaClaveNueva(){

        cajaFuerte.cerrarCon(clave);
        cajaFuerte.abrirCon(clave);
        Integer claveNueva = 9875;
        cajaFuerte.cerrarCon(claveNueva);
        //ejecucion
        cajaFuerte.abrirCon(claveNueva);
        // validacion (esperado vs real)
        entoncesEstaAbiertaLa(cajaFuerte);
    }

    @Test
    public void luegoDeAperturaExitosaSeReseteanLosIntentosFallidos(){
        //preparacion
        cajaFuerte.cerrarCon(clave);
        cajaFuerte.abrirCon(claveErronea);
        cajaFuerte.abrirCon(claveErronea);
        cajaFuerte.abrirCon(clave);

        cajaFuerte.cerrarCon(clave);
        cajaFuerte.abrirCon(claveErronea);

        // validacion
        entoncesNoEstaBloqueada(cajaFuerte);
    }

    @Test
    public void seBolaqueaDespuesDe3IntentosFallidos(){
        //preparacion
        cajaFuerte.cerrarCon(clave);
        cajaFuerte.abrirCon(claveErronea);
        cajaFuerte.abrirCon(claveErronea);

        // ejecucion
        cajaFuerte.abrirCon(claveErronea);
        // validacion
        entoncesEstaBloqueada(cajaFuerte);
    }

    private void entoncesNoEstaBloqueada(CajaFuerte cajaFuerte) {
        assertThat(cajaFuerte.estaBloqueada()).isFalse();
    }

    private void entoncesEstaBloqueada(CajaFuerte cajaFuerte) {
        assertThat(cajaFuerte.estaAbierta()).isFalse();
        assertThat(cajaFuerte.estaBloqueada()).isTrue();
    }

    private void entoncesEstaCerradaLa(CajaFuerte cajaFuerte) {
        assertThat(cajaFuerte.estaAbierta()).isFalse();
        // validaQue(ESTO).cumpleCon()
    }

    private void entoncesEstaAbiertaLa(CajaFuerte cajaFuerte) { // COMO
        assertThat(cajaFuerte.estaAbierta()).isTrue();
    }
}
