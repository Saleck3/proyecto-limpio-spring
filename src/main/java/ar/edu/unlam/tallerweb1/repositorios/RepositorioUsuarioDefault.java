package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioDefault implements RepositorioBarrio{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioUsuarioDefault(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Barrio buscarPor(String nombre) {
        return (Barrio) sessionFactory.getCurrentSession()
                .createCriteria(Barrio.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }
}
