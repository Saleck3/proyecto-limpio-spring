package ar.edu.unlam.tallerweb1.domain.productos;

import java.util.List;

public interface RepositorioProducto {

    public void guardar(Producto producto);

    public void actualizar(Producto producto);

    public void eliminar(Producto producto);

    public List<Producto> obtenerListaDeProductosPorNombre(String nombre);
}
