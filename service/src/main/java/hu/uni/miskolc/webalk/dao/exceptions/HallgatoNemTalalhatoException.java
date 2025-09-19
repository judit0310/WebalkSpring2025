package hu.uni.miskolc.webalk.dao.exceptions;

public class HallgatoNemTalalhatoException extends Exception {
    public HallgatoNemTalalhatoException(String id) {
        super(String.format("A %s azonosítojú hallgato nem találhato", id));
    }
}
