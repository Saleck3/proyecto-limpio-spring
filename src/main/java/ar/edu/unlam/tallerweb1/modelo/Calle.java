package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Calle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean dobleMano;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getDobleMano() {
        return dobleMano;
    }

    public void setDobleMano(Boolean dobleMano) {
        this.dobleMano = dobleMano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
