package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.service.HallgatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HallgatoController {

    @ModelAttribute("hallgato")
    public Hallgato hallgato(){
        Hallgato h = new Hallgato();
        return h;
    }


    @GetMapping("hello")
    public String hello(){
        System.out.println("hello");
        System.out.println(service.getHallgatok());
        return "hello";
    }

    public HallgatoService service;

    public HallgatoController(@Autowired HallgatoService service) {
        this.service = service;
    }

    @GetMapping("hallgatok")
    public ModelAndView osszesHallgato(){
            ModelAndView mav = new ModelAndView("hallgatok");
            mav.addObject("hallgatok", service.getHallgatok());
            return mav;
    }

    @GetMapping("ujHallgato")
    public ModelAndView ujHallgato(){
        ModelAndView mav = new ModelAndView("ujHallgato");
        return mav;
    }
    @PostMapping("ujHallgato")
    public ModelAndView ujHallgato(@ModelAttribute("hallgato") Hallgato hallgato){
        System.out.println(hallgato);
        ModelAndView mav = new ModelAndView("ujHallgato");
        mav.addObject("message", "A(z) "+hallgato.getNeptunKod()+" azonosíto már foglalt");
        return mav;
    }

}
