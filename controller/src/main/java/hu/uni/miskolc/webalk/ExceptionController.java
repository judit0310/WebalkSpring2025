package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@ResponseBody
public class ExceptionController {


    @ExceptionHandler(HallgatoNemTalalhatoException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String hallgatoNemTalalhato(HallgatoNemTalalhatoException e) {
        return e.getMessage();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public String httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        return "This method is not allowed for this request: "+e.getMethod()+", use one of these: "+String.join(", ", e.getSupportedMethods());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String noHandlerFound(NoHandlerFoundException e) {
        return e.getRequestURL().toString() + "not found";
    }
}
