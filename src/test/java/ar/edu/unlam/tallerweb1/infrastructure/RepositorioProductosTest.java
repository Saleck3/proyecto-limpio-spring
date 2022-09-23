package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.productos.Producto;
import ar.edu.unlam.tallerweb1.domain.productos.RepositorioProducto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioProductosTest extends SpringTest {

    @Autowired
    private RepositorioProducto repositorioProducto;

    @Test
    @Rollback
    @Transactional
    public void debeDevolverCeroProductosManzanaSinoNoHayManzanas(){
        
        dadoQueHayProductosCargadosPeroNingunaManzana();
        List<Producto> listaProductos = cuandoConsultoPorElProducto("Manzana");
        entoncesObtengoCeroManzanas(listaProductos);
    }

    private void entoncesObtengoCeroManzanas(List<Producto> listaProductos){
        assertThat(listaProductos).hasSize(0);
    }

    private List<Producto> cuandoConsultoPorElProducto(String nombreProducto) {
        return repositorioProducto.obtenerListaDeProductosPorNombre(nombreProducto);
    }

    private void dadoQueHayProductosCargadosPeroNingunaManzana() {
        Producto producto1 = new Producto();
        producto1.setNombre("Banana");

        session().save(producto1);

        Producto producto2 = new Producto();
        producto2.setNombre("Kiwi");

        session().save(producto2);
    }


}
