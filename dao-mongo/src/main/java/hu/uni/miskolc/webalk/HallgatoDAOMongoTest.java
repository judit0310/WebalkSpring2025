package hu.uni.miskolc.webalk;


import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezikException;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import hu.uni.miskolc.webalk.service.HallgatoService;

import java.time.LocalDate;

class HallgatoDAOMongoTest {
    public static void main(String[] args) throws HallgatoMarLetezikException, HallgatoNemTalalhatoException {

        HallgatoDAOMongo dao = new HallgatoDAOMongo("mongodb+srv://test:test@ktj.jxln5hy.mongodb.net/?retryWrites=true&w=majority&appName=KTJ",
                "GUPNWY", "hallgatok");
        Hallgato h = new Hallgato("AB2111", "Nagy Milán", "nagy.milan@pelda.hu", LocalDate.now(), Nem.FERFI);

        //dao.createHallgato(h);
        //System.out.println(dao.getHallgatoById("AA2111"));
        //h.setEmail("megseezvolt@pelda.hu");
        //dao.updateHallgato(h);
        //System.out.println(dao.getHallgatoById("AB2111"));
       // dao.deleteHallgato("AA2111");
        //System.out.println(dao.getHallgatoById("AA2111"));
    }
}