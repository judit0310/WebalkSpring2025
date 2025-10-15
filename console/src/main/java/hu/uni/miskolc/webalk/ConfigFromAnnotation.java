package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezikException;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import hu.uni.miskolc.webalk.service.HallgatoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class ConfigFromAnnotation
{
    public static void main(String[] args) throws HallgatoMarLetezikException, HallgatoNemTalalhatoException {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        HallgatoService service = (HallgatoService) context.getBean("hallgatoService");
        //System.out.println(service.getHallgatok());
        System.out.println(service.getHallgatokByNem(Nem.NO));

      /*  Hallgato h = new Hallgato("AAB111", "Nagy Milán", "nagy.milan@pelda.hu", LocalDate.now(), Nem.FERFI);
        //service.addHallgato(h);
        System.out.println(service.getHallgatok());
        h.setEmail("kiscica@pelda.hu");
        service.updateHallgato(h);
        System.out.println(service.getHallgatok());*/
    }
}
