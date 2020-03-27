package practicumopdracht.data;

import practicumopdracht.models.Groep;

import java.util.List;

public abstract class GroepDAO implements DAO<Groep> {
    List<Groep> groepList;

    @Override
    public List<Groep> getAll() {
        return null;
    }

    @Override
    public Groep get(int id) {
        return null;
    }

    @Override
    public void addOrUpdate(Groep object) {

    }

    @Override
    public void remove(Groep object) {

    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        return false;
    }

//    private int getUniqueId() {
//
//    }
}
