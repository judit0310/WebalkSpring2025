package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezikException;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import hu.uni.miskolc.webalk.service.HallgatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class HallgatoRESTController {
    private final HallgatoService hallgatoService;

    public HallgatoRESTController(@Autowired HallgatoService hallgatoService) {
        this.hallgatoService = hallgatoService;
    }

    @GetMapping("hello")
    public String hellorest() {
        return "Hello";
    }


    @GetMapping("hallgatok")
    public List<Hallgato> getHallgatok() {
        return hallgatoService.getHallgatok();
    }


    @GetMapping("hallgato/{id:[A-Z0-9]{6}}")
    public Hallgato getHallgato(@PathVariable(name = "id") String id) throws HallgatoNemTalalhatoException {
        return hallgatoService.getHallgatoByNeptunKod(id);
    }


    @PostMapping(value = "addHallgato", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addHallgato(@Valid @RequestBody HallgatoDTO hallgato, BindingResult result) throws HallgatoNemTalalhatoException, HallgatoMarLetezikException {
        if (result.hasErrors()) {
            return result.getFieldErrors().stream().map(e -> e.getField() + " " + e.getDefaultMessage()).collect(Collectors.joining("\n"));
        }
        hallgatoService.addHallgato(HallgatoDTO.getHallgatoFromHallgatoDTO(hallgato));
        return hallgato.toString();
    }


    @GetMapping("hallgatok/{vezeteknev}")
    public List<HallgatoDTO> getHallgatokByVezeteknev(@PathVariable(name = "vezeteknev") String vezeteknev) {
        return hallgatoService.getHallgatoByVezeteknev(vezeteknev).stream().map(HallgatoDTO::getHallgatoDTOFromHallgato).collect(Collectors.toList());
    }

    @GetMapping("hallgatok/evek")
    public List<HallgatoDTO> getHallgatokEvekKozott(@RequestParam(name = "fromYear", required = true) int fromYear, @RequestParam(name = "toYear", defaultValue = "3000") int toYear
    ) {
        if(fromYear > toYear){
            throw new InvalidParameterException("A kezdő év nem lehet a végév után");
        }
        return hallgatoService.getHallgatokKetEvKozott(fromYear, toYear).stream().map(HallgatoDTO::getHallgatoDTOFromHallgato).collect(Collectors.toList());
    }

    @GetMapping("hallgatokNemSzerint/{nem}")
    public List<Hallgato> getHallgatoByNem(@PathVariable(name = "nem") Nem nem){
        return hallgatoService.getHallgatokNemSzerint(nem);

//        String test;
//
//            for (Nem c : Nem.values()) {
//                if (c.name().equals(test)) {
//                    return true;
//                }
//            }
//
//            return false;
//        }


    }


//    @ExceptionHandler(HallgatoNemTalalhatoException.class)
//    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
//    public String hallgatoNemTalalhato(HallgatoNemTalalhatoException e) {
//        return e.getMessage();
//    }
}
