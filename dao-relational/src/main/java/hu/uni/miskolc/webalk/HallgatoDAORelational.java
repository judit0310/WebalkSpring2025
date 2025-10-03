package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.dao.HallgatoDAO;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezikException;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Repository
public class HallgatoDAORelational implements HallgatoDAO{
    private static SessionFactory factory;

    public HallgatoDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public List<Hallgato> getAllHallgato() {
        Session session = factory.openSession();
        List<Hallgato> result = session.createQuery("FROM Hallgato").list();
        session.close();
        return result;
    }

    @Override
    public Hallgato getHallgatoById(String id) throws HallgatoNemTalalhatoException {
        Session session = factory.openSession();
        String hql = "From Hallgato Where id = :id";
        Query q = session.createQuery(hql);
        q.setParameter("id",id);
        Optional<Hallgato> result = q.stream().findFirst();
        return result.get();
    }


    @Override
    public void createHallgato(Hallgato hallgato) throws HallgatoMarLetezikException {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(hallgato);
            transaction.commit();
        } catch (Exception exception){
            transaction.rollback();
            throw new HallgatoMarLetezikException(hallgato.getNeptunKod());
        }
        session.close();
    }

    @Override
    public void updateHallgato(Hallgato hallgato) {

    }

    @Override
    public void deleteHallgato(String id) {

    }
}