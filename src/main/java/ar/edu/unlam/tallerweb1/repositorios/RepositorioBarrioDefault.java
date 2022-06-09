package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Direccion;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioBarrioDefault implements RepositorioBarrio{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioBarrioDefault(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Direccion> buscarPor(String nombre) {
        return  sessionFactory.getCurrentSession()
                .createCriteria(Direccion.class)
                .createAlias("barrio", "barrio")
                .add(Restrictions.eq("barrio.nombre", nombre))
                .list();
    }
}
