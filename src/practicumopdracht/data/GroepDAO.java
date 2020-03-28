package practicumopdracht.data;

import practicumopdracht.models.Groep;

import java.util.ArrayList;
import java.util.List;

public abstract class GroepDAO implements DAO<Groep> {
    List<Groep> groep;

    //directe load methode instantiëren
    public GroepDAO() {
        load();
    }

    @Override
    public List<Groep> getAll() {
        return new ArrayList<>(groep);
    }

    @Override
    public Groep get(int id) {
        for (Groep g : groep) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    @Override
    public void addOrUpdate(Groep object) {
        if (object.getId() > 0) {
            int index = groep.indexOf(get(object.getId()));
            groep.remove(index);
            groep.add(index, object);
        } else {
            object.setId(getUniqueId());
            groep.add(object);
        }
    }

    @Override
    public void remove(Groep object) {
        groep.remove(get(object.getId()));
    }

    @Override
    public abstract boolean save();

    @Override
    public abstract boolean load();

    private int getUniqueId() {
        int maxId = 0;
        for (Groep g : groep) {
            if (g.getId() > maxId) {
                maxId = g.getId();
            }
        }
        maxId++;
        return maxId;

    }
}
