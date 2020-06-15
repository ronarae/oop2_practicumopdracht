package practicumopdracht.data;

import practicumopdracht.models.Contact;
import practicumopdracht.models.Groep;


import java.util.ArrayList;
import java.util.List;

public abstract class ContactDAO implements DAO<Contact> {
    protected List<Contact> objects;
    private int id = 0;

    public List<Contact> getAllFor(Groep object) {
        ArrayList<Contact> contactArrayList = new ArrayList<>();
        for (Contact c : objects) {
            if (object.getId() == c.getMasterId()) {
                contactArrayList.add(c);
            }
        }
        return contactArrayList;
    }

    public ContactDAO() {
        load();
    }

    @Override
    public List<Contact> getAll() {
        return new ArrayList<>(objects);
    }

    @Override
    public Contact get(int id) {
        for (Contact c : objects) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;

    }

    @Override
    public void addOrUpdate(Contact object) {
        if (object.getId() > 0) {
            int index = objects.indexOf(get(object.getId()));
            objects.remove(index);
            objects.add(index, object);
        } else {
            object.setId(getUniqueId());
            objects.add(object);
        }
    }

    @Override
    public void remove(Contact object) {
        objects.remove(get(object.getId()));
    }

    @Override
    public abstract boolean save();

    @Override
    public abstract boolean load();

     private int getUniqueId() {
         int maxId = 0;
         for (Contact c : objects) {
             if (c.getId() > maxId) {
                 maxId = c.getId();
             }
         }
         maxId++;
         return maxId;
    }
}
