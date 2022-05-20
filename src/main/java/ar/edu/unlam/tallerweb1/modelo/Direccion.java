package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private Integer altura;
    private Integer piso;
    @ManyToOne
    @JoinColumn(name = "barrio_id")
    private Barrio barrio;

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }
}
