package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component @Transactional
public class SetUp {

    @Autowired
    private SessionFactory sessionFactory;

    @PostConstruct
    private void loadBarrio() {
        Barrio ramos = new Barrio();
        ramos.setNombre("haedo");
        sessionFactory.openSession().save(ramos);

        Direccion d1 = new Direccion();
        d1.setCalle("Peru");
        d1.setBarrio(ramos);
        sessionFactory.openSession().save(d1);

        Direccion d2 = new Direccion();
        d2.setCalle("Chile");
        d2.setBarrio(ramos);
        sessionFactory.openSession().save(d2);
    }
}
