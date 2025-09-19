package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.dao.HallgatoDAO;
import hu.uni.miskolc.webalk.service.HallgatoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan("hu.uni.miskolc.webalk")
public class MyConfig {
    //Ha itt marad a Bean, akkor kettőt is talál
    @Bean
    public HallgatoDAO getHallgatoDAO() {
        return new HallgatoDAOMongo("mongodb+srv://test:test@ktj.jxln5hy.mongodb.net/?retryWrites=true&w=majority&appName=KTJ",
                "GUPNWY", "hallgatok");
    }


}
