package hu.uni.miskolc.webalk.dao;

import hu.uni.miskolc.webalk.Hallgato;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezikException;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;

import java.util.ArrayList;
import java.util.List;

public interface HallgatoDAO {
    default List<Hallgato> getAllHallgato(){
        return new ArrayList<Hallgato>();
    }

    Hallgato getHallgatoById(String id) throws HallgatoNemTalalhatoException;

    void createHallgato(Hallgato hallgato) throws HallgatoMarLetezikException;

    void updateHallgato(Hallgato hallgato);

    void deleteHallgato(String id);
}
