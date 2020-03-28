package practicumopdracht.models;

import java.time.LocalDate;

public class Groep {
    private String groepNaam;
    private LocalDate datumToegevoegd;
    private int id;

    public Groep(String groepNaam, LocalDate datumToegevoegd, int id) {
        this.groepNaam = groepNaam;
        this.datumToegevoegd = datumToegevoegd;
        this.id = id;
    }

    public Groep(String groepNaam, LocalDate datumToegevoegd) {
        this.groepNaam = groepNaam;
        this.datumToegevoegd = datumToegevoegd;
    }

    public String getGroepNaam() {
        return groepNaam;
    }

    public void setGroepNaam(String groepNaam) {
        this.groepNaam = groepNaam;
    }

    public LocalDate getDatumToegevoegd() {
        return datumToegevoegd;
    }

    public void setDatumToegevoegd(LocalDate datumToegevoegd) {
        this.datumToegevoegd = datumToegevoegd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
