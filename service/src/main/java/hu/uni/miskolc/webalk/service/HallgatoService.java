package hu.uni.miskolc.webalk.service;


import hu.uni.miskolc.webalk.Hallgato;
import hu.uni.miskolc.webalk.Nem;
import hu.uni.miskolc.webalk.dao.HallgatoDAO;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezikException;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
@Service
public class HallgatoService {
    private final HallgatoDAO hallgatoDAO;

    public HallgatoService(@Autowired HallgatoDAO hallgatoDAO) {
        this.hallgatoDAO = hallgatoDAO;
    }

    public List<Hallgato> getHallgatok() {
        return hallgatoDAO.getAllHallgato();
    }

    public void addHallgato(Hallgato hallgato) throws HallgatoMarLetezikException {
        hallgatoDAO.createHallgato(hallgato);
    }

    public Hallgato getHallgatoByNeptunKod(String neptunKod) throws HallgatoNemTalalhatoException {
        return hallgatoDAO.getHallgatoById(neptunKod);
    }


    public List<Hallgato> getHallgatokByNem(Nem nem) {
        List<Hallgato> eredmeny = new ArrayList<>();
        List<Hallgato> osszes = hallgatoDAO.getAllHallgato();
        for (Hallgato hallgato : osszes) {
            if (hallgato.getNem().equals(nem)) {
                eredmeny.add(hallgato);
            }
        }
        return eredmeny;

    }
}
