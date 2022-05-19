package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Calle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class RepositorioCalleHibernateImpl implements RepositorioCalle {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioCalleHibernateImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    public List<Calle> buscarPorNombre(String nombre){
        final Session session = sessionFactory.getCurrentSession();
//        List l1 = session.createSQLQuery("select * from TABLA_CALLES where NOMBRE_CALLE='" + nombre + "'")
//                .list();// mundo DB

//        List l2 = session.createQuery("from Calle where nombre = :n")
//                .setParameter("n", nombre)
//                .list();// HQL mundo OO

        return session.createCriteria(Calle.class)
                .add(Restrictions.eq("nombre", nombre))
                .list(); // mmundo OO
    }

    @Override
    public List<Calle> buscarPorNombreYSentido(String nombre, boolean esDobleMano) {
        return sessionFactory.getCurrentSession()
                .createCriteria(Calle.class)
                .add(Restrictions.eq("nombre", nombre))
                .add(Restrictions.eq("dobleMano", esDobleMano))
                .list();
    }

    @Override
    public List<Calle> buscarPorNombreLike(String nombre) {
        return sessionFactory.getCurrentSession()
                .createCriteria(Calle.class)
                .add(Restrictions.like("nombre", nombre+"%"))
                .list();
    }
}
