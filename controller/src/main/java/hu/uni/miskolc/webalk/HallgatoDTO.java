package hu.uni.miskolc.webalk;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class HallgatoDTO {

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]{6}$", message = "A neptun kodnak 6 hosszuságúnak kell lennie")
    @Pattern(regexp = "^[A-Z0-9]{6}$", message = "A neptun kod nem tartalmazhat kis betűt")
    private String neptunKod;

    @Size(min = 7, max = 50)
    private String teljesNev;

    @Email
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    @Past
    private LocalDate szuletesiDatum;

    private Nem nem;


    public HallgatoDTO() {
    }

    public HallgatoDTO(String neptunKod, String teljesNev, String email, LocalDate szuletesiDatum, Nem nem) {
        this.neptunKod = neptunKod;
        this.teljesNev = teljesNev;
        this.email = email;
        this.szuletesiDatum = szuletesiDatum;
        this.nem = nem;
    }


    public String getNeptunKod() {
        return neptunKod;
    }

    public void setNeptunKod(String neptunKod) {
        this.neptunKod = neptunKod;
    }

    public String getTeljesNev() {
        return teljesNev;
    }

    public void setTeljesNev(String teljesNev) {
        this.teljesNev = teljesNev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getSzuletesiDatum() {
        return szuletesiDatum;
    }

    public void setSzuletesiDatum(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate szuletesiDatum) {
        this.szuletesiDatum = szuletesiDatum;
    }

    public Nem getNem() {
        return nem;
    }

    public void setNem(Nem nem) {
        this.nem = nem;
    }

    @Override
    public String toString() {
        return "Hallgato{" +
                "neptunKod='" + neptunKod + '\'' +
                ", teljesNev='" + teljesNev + '\'' +
                ", email='" + email + '\'' +
                ", szuletesiDatum=" + szuletesiDatum +
                ", nem=" + nem +
                '}';
    }

    public static Hallgato getHallgatoFromHallgatoDTO(HallgatoDTO hallgatoDTO) {
        Hallgato hallgato = new Hallgato(hallgatoDTO.neptunKod, hallgatoDTO.teljesNev, hallgatoDTO.email, hallgatoDTO.szuletesiDatum, hallgatoDTO.nem);
        return hallgato;
    }

    public static HallgatoDTO getHallgatoDTOFromHallgato(Hallgato hallgato) {
        HallgatoDTO hallgatoDTO = new HallgatoDTO(hallgato.getNeptunKod(), hallgato.getTeljesNev(), hallgato.getEmail(), hallgato.getSzuletesiDatum(), hallgato.getNem());
        return hallgatoDTO;
    }


}
