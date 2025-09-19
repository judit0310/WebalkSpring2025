package hu.uni.miskolc.webalk.service;


import hu.uni.miskolc.webalk.Hallgato;
import hu.uni.miskolc.webalk.Nem;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class HallgatoService {
    public HallgatoService() {

    }


    private static final ArrayList<Hallgato> hallgatok;

    static {
        hallgatok = new ArrayList<>();
        Hallgato h1 = new Hallgato("ABC123", "Kiss Béla", "kiss.bela@pelda.hu", LocalDate.of(2000, Month.AUGUST, 12), Nem.FERFI);
        hallgatok.add(h1);
    }

    public List<Hallgato> getAllHallgato() {
        return hallgatok;
    }

    public void addHallgato(Hallgato hallgato) {
        hallgatok.add(hallgato);
    }
}
