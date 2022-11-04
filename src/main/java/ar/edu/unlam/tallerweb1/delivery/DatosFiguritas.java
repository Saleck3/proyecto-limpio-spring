package ar.edu.unlam.tallerweb1.delivery;

public class DatosFiguritas {

    private final Integer numero;
    private final String equipo;

    public DatosFiguritas(Integer numero, String equipo) {
        this.numero = numero;
        this.equipo = equipo;
    }

    public Integer getNumero(){
        return this.numero;
    }

    public String getEquipo(){
        return this.equipo;
    }
}
