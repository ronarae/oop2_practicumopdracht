package practicumopdracht.data;

import practicumopdracht.models.Groep;

import java.util.List;

public abstract class GroepDAO implements DAO<Groep> {
    protected List<Groep> objects;
    private int id = 0;

    //directe load methode instantiëren
    public GroepDAO() {
        load();
    }

    @Override
    public List<Groep> getAll() {
        return objects;
    }

    @Override
    public Groep get(int id) {
        for (Groep g : objects) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    @Override
    public void addOrUpdate(Groep object) {
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
    public void remove(Groep object) {
        objects.remove(get(object.getId()));
    }

    @Override
    public abstract boolean save();

    @Override
    public abstract boolean load();

    private int getUniqueId() {
        int maxId = 0;
        for (Groep g : objects) {
            if (g.getId() > maxId) {
                maxId = g.getId();
            }
        }
        maxId++;
        return maxId;

    }
}
