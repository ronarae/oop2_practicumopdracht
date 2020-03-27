package practicumopdracht.data;

import practicumopdracht.models.Contact;
import practicumopdracht.models.Groep;


import java.util.ArrayList;
import java.util.List;

public abstract class ContactDAO implements DAO<Contact> {
    List<Contact> contactList;

    public List<Contact> getAllFor(Groep object) {
        ArrayList<Contact> arrayList = new ArrayList<>();

        return arrayList;
    }

    @Override
    public List<Contact> getAll() {
        return null;
    }

    @Override
    public Contact get(int id) {
        return null;
    }

    @Override
    public void addOrUpdate(Contact object) {

    }

    @Override
    public void remove(Contact object) {

    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        return false;
    }

    // private int getUniqueId() {
//
//    }
}
