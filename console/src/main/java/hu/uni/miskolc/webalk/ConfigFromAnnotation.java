package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.service.HallgatoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class ConfigFromAnnotation
{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        HallgatoService service = (HallgatoService) context.getBean("hallgatoService");
        System.out.println(service.getHallgatok());
        System.out.println(service.getHallgatokByNem(Nem.EGYEB));
    }
}
