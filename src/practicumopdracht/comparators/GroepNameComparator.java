package practicumopdracht.comparators;

import practicumopdracht.enums.Soorteren;
import practicumopdracht.models.Groep;

import java.util.Comparator;

public class GroepNameComparator implements Comparator<Groep> {

    public Soorteren soort;

    public GroepNameComparator(Soorteren soort) {
        this.soort = soort;
    }

    @Override
    public int compare(Groep groep1, Groep groep2) {
        switch (soort) {
            case ASCENDING:
                return compareGroep(groep1, groep2);

            case DESCENDING:
                return -compareGroep(groep1, groep2);
        }
        return 0;
    }

    private int compareGroep(Groep groep1, Groep groep2) {
        return groep1.getGroepNaam().compareTo(groep2.getGroepNaam());
    }
}
