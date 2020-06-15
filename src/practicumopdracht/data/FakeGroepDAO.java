package practicumopdracht.data;

import practicumopdracht.models.Groep;

import java.time.LocalDate;
import java.util.ArrayList;

public class FakeGroepDAO extends GroepDAO {
    @Override
    public boolean load() {
        objects = new ArrayList<>();
        objects.add(new Groep("Family", LocalDate.now()));
        objects.add(new Groep("Friends", LocalDate.now()));
        return true;
    }

    @Override
    public boolean save() {
        return false;
    }
}
