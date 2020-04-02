package practicumopdracht.data;

import practicumopdracht.models.Groep;

import java.time.LocalDate;
import java.util.ArrayList;

public class FakeGroepDAO extends GroepDAO {
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        try {
            groep = new ArrayList<>();
            groep.add(new Groep("Family", LocalDate.now()));
            groep.add(new Groep("Friends", LocalDate.now()));
            groep.add(new Groep("School", LocalDate.now()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
