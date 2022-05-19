package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioFarmaciaHibernateImpl implements RepositorioFarmacia{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioFarmaciaHibernateImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Farmacia> buscarPorNombreDeCalle(String nombreCalle) {
        return sessionFactory.getCurrentSession()
                .createCriteria(Farmacia.class)
                .createAlias("direccion", "dir")
                .add(Restrictions.eq("dir.calle", nombreCalle))
                .list();
    }
}
