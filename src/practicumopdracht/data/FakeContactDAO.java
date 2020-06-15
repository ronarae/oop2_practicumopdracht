package practicumopdracht.data;

import practicumopdracht.models.Contact;
import practicumopdracht.models.Groep;

import java.time.LocalDate;
import java.util.ArrayList;

public class FakeContactDAO extends ContactDAO {
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        objects = new ArrayList<>();
        try {
            objects.add(new Contact("Rona", LocalDate.of(1993,9,23),
                    "rona@email.com", "Het Laagt", 39, "1025GC",
                    "Amsterdam", 5, 2, 1));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
