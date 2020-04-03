package practicumopdracht.comparators;

import practicumopdracht.enums.Soorteren;
import practicumopdracht.models.Contact;
import practicumopdracht.models.Groep;

import java.util.Comparator;

public class ContactNameComparator implements Comparator<Contact> {

    Soorteren soort;

    public ContactNameComparator(Soorteren soort) {
        this.soort = soort;
    }

    @Override
    public int compare(Contact contact1, Contact contact2) {
        switch (soort) {
            case ASCENDING:
                return compareContact(contact1, contact2);

            case DESCENDING:
                return -compareContact(contact1, contact2);
        }
        return 0;
    }

    private int compareContact(Contact contact1, Contact contact2) {
        return contact1.getNaam().compareTo(contact2.getNaam());
    }
}
