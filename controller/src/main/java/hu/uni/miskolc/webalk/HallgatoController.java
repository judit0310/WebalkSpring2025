package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezikException;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import hu.uni.miskolc.webalk.service.HallgatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HallgatoController {

    @ModelAttribute("hallgato")
    public HallgatoDTO hallgato(){
        HallgatoDTO h = new HallgatoDTO();
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
    public ModelAndView ujHallgato(@ModelAttribute("hallgato") @Valid HallgatoDTO hallgato, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("ujHallgato");
            return mav;
        }
        try {
            service.addHallgato(HallgatoDTO.getHallgatoFromHallgatoDTO(hallgato));
            ModelAndView mav = new ModelAndView("redirect:/hallgatok");
            return mav;
        } catch (HallgatoMarLetezikException e) {
            ModelAndView mav = new ModelAndView("ujHallgato");
            mav.addObject("message", "A(z) "+hallgato.getNeptunKod()+" azonosíto már foglalt");
            return mav;
        }

    }

    @GetMapping("hallgato/{id}")
    public ModelAndView ujHallgato(@PathVariable(name = "id") String neptunKod) throws HallgatoNemTalalhatoException {
        ModelAndView mav = new ModelAndView("ujHallgato");
        Hallgato hallgato = service.getHallgatoByNeptunKod(neptunKod);
        mav.addObject("hallgato", hallgato);
        mav.addObject("method","View");
        return mav;
    }

}
