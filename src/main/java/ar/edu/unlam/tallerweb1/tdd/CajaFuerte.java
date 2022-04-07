package ar.edu.unlam.tallerweb1.tdd;

public class CajaFuerte {
    public static final int CANT_INTENTOS_FALLIDOS_PARA_BLOQUEAR = 3;
    private Integer claveDeApertura;
    private Boolean estaAbierta;
    private Integer cantidadDeIntentosFallidos;

    public CajaFuerte() {
        estaAbierta = true;
        cantidadDeIntentosFallidos = 0;
    }

    public void cerrarCon(Integer clave) {
        claveDeApertura = clave;
        estaAbierta = false;
    }

    public void abrirCon(Integer clave) {
        if (clave.equals(claveDeApertura)){
            cantidadDeIntentosFallidos = 0;
            estaAbierta = true;
        }
        else
            cantidadDeIntentosFallidos++;
    }

    public boolean estaAbierta() {
        return estaAbierta;
    }

    public boolean estaBloqueada() {
        return cantidadDeIntentosFallidos >= CANT_INTENTOS_FALLIDOS_PARA_BLOQUEAR;
    }
}
