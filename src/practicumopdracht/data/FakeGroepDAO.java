package practicumopdracht.data;

public class FakeGroepDAO extends GroepDAO {
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        return false;
    }
}
