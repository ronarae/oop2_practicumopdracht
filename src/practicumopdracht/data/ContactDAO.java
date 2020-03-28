package practicumopdracht.data;

import practicumopdracht.models.Contact;
import practicumopdracht.models.Groep;


import java.util.ArrayList;
import java.util.List;

public abstract class ContactDAO implements DAO<Contact> {
    List<Contact> contact;

    public List<Contact> getAllFor(Groep object) {
        ArrayList<Contact> arrayList = new ArrayList<>();
        for (Contact c : contact) {
            if (object.getId() == c.getMasterId()) {
                arrayList.add(c);
            }
        }
        return arrayList;
    }

    public ContactDAO() {
        load();
    }

    @Override
    public List<Contact> getAll() {
        return new ArrayList<>(contact);
    }

    @Override
    public Contact get(int id) {
        for (Contact c : contact) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;

    }

    @Override
    public void addOrUpdate(Contact object) {
        if (object.getId() > 0) {
            int index = contact.indexOf(get(object.getId()));
            contact.remove(index);
            contact.add(index, object);
        } else {
            object.setId(getUniqueId());
            contact.add(object);
        }
    }

    @Override
    public void remove(Contact object) {
        contact.remove(get(object.getId()));
    }

    @Override
    public abstract boolean save();

    @Override
    public abstract boolean load();

     private int getUniqueId() {
         int maxId = 0;
         for (Contact c : contact) {
             if (c.getId() > maxId) {
                 maxId = c.getId();
             }
         }
         maxId++;
         return maxId;
    }
}
