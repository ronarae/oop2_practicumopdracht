package practicumopdracht.models;

import java.time.LocalDate;

public class Groep {
    private String groepNaam;
    private LocalDate datumToegevoegd;

    public Groep(String groepNaam, LocalDate datumToegevoegd) {
        this.groepNaam = groepNaam;
        this.datumToegevoegd = datumToegevoegd;
    }
}
