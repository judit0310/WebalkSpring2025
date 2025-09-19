package hu.uni.miskolc.webalk.dao.exceptions;

public class HallgatoMarLetezikException extends Exception {
    public HallgatoMarLetezikException(String id) {
        super(String.format("A %s azonosítojú hallgato már létezik", id));
    }
}
