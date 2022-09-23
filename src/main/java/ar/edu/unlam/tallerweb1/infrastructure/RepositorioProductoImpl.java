package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.productos.Producto;
import ar.edu.unlam.tallerweb1.domain.productos.RepositorioProducto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioProductoImpl implements RepositorioProducto {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioProductoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Producto producto) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(producto);
    }

    @Override
    public void actualizar(Producto producto) {
        final Session session = sessionFactory.getCurrentSession();
        session.update(producto);
    }

    @Override
    public void eliminar(Producto producto) {
        final Session session = sessionFactory.getCurrentSession();
        session.delete(producto);
    }

    @Override
    public List<Producto> obtenerListaDeProductosPorNombre(String nombre) {
        final Session session = sessionFactory.getCurrentSession();

        return (List<Producto>) session.createCriteria(Producto.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
    }
}
