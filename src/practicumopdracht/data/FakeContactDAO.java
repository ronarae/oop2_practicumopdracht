package practicumopdracht.data;

public class FakeContactDAO extends ContactDAO {
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        return false;
    }
}
