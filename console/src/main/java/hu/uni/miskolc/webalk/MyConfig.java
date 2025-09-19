package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.service.HallgatoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean("hallgatoService")
    public HallgatoService hallgatoServiceInit() {
        return new HallgatoService();
    }
}
