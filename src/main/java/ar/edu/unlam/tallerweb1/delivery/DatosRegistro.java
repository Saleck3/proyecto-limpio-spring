package ar.edu.unlam.tallerweb1.delivery;

public class DatosRegistro {
    private String usuario;
    private String clave;
    private String repiteClave;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setRepiteClave(String repiteClave) {
        this.repiteClave = repiteClave;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public String getRepiteClave() {
        return repiteClave;
    }

    public DatosRegistro(String usuario, String clave, String repiteClave) {
        this.usuario = usuario;
        this.clave = clave;
        this.repiteClave = repiteClave;
    }

    public DatosRegistro() {

    }
}
