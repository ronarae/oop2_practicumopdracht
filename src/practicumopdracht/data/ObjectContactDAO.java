package practicumopdracht.data;

import practicumopdracht.models.Contact;
import practicumopdracht.models.Groep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectContactDAO extends ContactDAO {
    private static final String FILENAME = "resources/ContactBestand.dat";

    @Override
    public boolean save() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILENAME)))) {
            objectOutputStream.writeObject(objects);
            return true;
        } catch (FileNotFoundException ex) {
            System.err.println("Contacten niet gevonden");
        } catch (NullPointerException ex) {
            System.err.println("Contact object is null");
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.err.println("Contact exception: " + ex);
        }
        return false;
    }

    @Override
    public boolean load() {
        objects = new ArrayList<>();

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILENAME)))) {

            while (true) {
                objects = ((List<Contact>) objectInputStream.readObject());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Contact not Found");
        } catch (EOFException ex) {
            System.err.println("Alle data is gelezen");
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.err.println("Contact exception: " + ex);
        }
        return false;
    }
}
