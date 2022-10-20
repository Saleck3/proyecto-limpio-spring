package ar.edu.unlam.tallerweb1.delivery;

public class DatosRegistro {
    private final String usuario;
    private final String clave;

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public String getRepiteClave() {
        return repiteClave;
    }

    private final String repiteClave;

    public DatosRegistro(String usuario, String clave, String repiteClave) {
        this.usuario = usuario;
        this.clave = clave;
        this.repiteClave = repiteClave;
    }
}
