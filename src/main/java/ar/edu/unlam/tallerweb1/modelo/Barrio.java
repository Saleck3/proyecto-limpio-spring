package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Barrio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "barrio")
    private Set<Direccion> lugares = new HashSet<>();

    public Set<Direccion> getLugares() {
        return lugares;
    }

    public void setLugares(Set<Direccion> lugares) {
        this.lugares = lugares;
    }

    public void agregar(Direccion direccion){
        lugares.add(direccion);
        direccion.setBarrio(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
