package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.dao.HallgatoDAO;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezikException;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.List;

@Repository
//@Primary
//@Lazy(false)
public class HallgatoDAORelacios implements HallgatoDAO{

    private static SessionFactory sessionFactory;


    @Override
    public List<Hallgato> getAllHallgato() {
        Session session = sessionFactory.openSession();
        List<Hallgato> result = session.createQuery("from Hallgato").list();
        session.close();
        return result;
    }

    public HallgatoDAORelacios() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Hallgato getHallgatoById(String id) throws HallgatoNemTalalhatoException {
        Session session = sessionFactory.openSession();
        List<Hallgato> result = session.createQuery("from Hallgato WHERE neptunKod = :id").setString("id",id).list();
        session.close();
        return result.get(0);
    }

    @Override
    public void createHallgato(Hallgato hallgato) throws HallgatoMarLetezikException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.save(hallgato);
            session.getTransaction().commit();
        }catch (PersistenceException exception){
            session.getTransaction().rollback();
            throw new HallgatoMarLetezikException(hallgato.getNeptunKod());
        }
        session.close();
    }

    @Override
    public void updateHallgato(Hallgato hallgato) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(hallgato);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteHallgato(String id) throws HallgatoNemTalalhatoException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.remove(session.get(Hallgato.class, id));
            session.getTransaction().commit();
        }catch (IllegalArgumentException exception){
            session.getTransaction().rollback();
            throw new HallgatoNemTalalhatoException(id);
        }
        session.close();


    }
}