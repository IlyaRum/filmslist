package testgroup.filmography.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import testgroup.filmography.model.Film;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FilmDAOImpl
        implements FilmDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Film> allFilms() {
        if (sessionFactory == null)
            System.out.println( "sessionFactory is " + sessionFactory );
        Session session = sessionFactory.getCurrentSession();
        List<Film> sessionList = session.createQuery( "from Film" ).list();
        return sessionList;
    }


    public void add(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.persist( film );
    }


    public void delete(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete( film );
    }


    public void edit(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.update( film );
    }


    public Film getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get( Film.class, id );
    }
}
