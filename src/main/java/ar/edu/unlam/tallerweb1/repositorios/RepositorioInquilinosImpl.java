package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Inquilino;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RepositorioInquilinos")
public class RepositorioInquilinosImpl implements RepositorioInquilinos {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioInquilinosImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Inquilino> findAll() {
        return (List<Inquilino>) sessionFactory.getCurrentSession().createCriteria(Inquilino.class).list();
    }

    @Override
    public Long save(Inquilino inquilino) {
        sessionFactory.getCurrentSession().save(inquilino);
        return inquilino.getId();
    }

    @Override
    public void delete(Long id){
        Inquilino inquilino = sessionFactory.getCurrentSession().get(Inquilino.class, id);
        sessionFactory.getCurrentSession().delete(inquilino);
        return;
    }

}
