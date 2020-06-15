package practicumopdracht.data;

import practicumopdracht.models.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectContactDAO extends ContactDAO {
    private static final String FILENAME = "/Users/ronar/oop2_practicumopdracht/resources/ContactBestand.dat";

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
            System.err.println("Contact"+ ex);
        } catch (Exception ex) {
            System.err.println("Contact exception: " + ex);
        }
        return false;
    }

    @Override
    public boolean load() {
        objects = new ArrayList<>();

        try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILENAME)))) {
            while (true) {
                objects = ((List<Contact>) input.readObject());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (EOFException e ) {
            System.err.println("End of File reached");
        } catch (IOException e) {
            System.err.println("IO Exception");
        } catch (ClassCastException e) {
            System.err.println("Class Cast Exception");
        } catch (ClassNotFoundException e) {
            System.err.println("Class Not Found Exception");
        } catch (Exception e) {
            System.err.println("Exception");
        }
        return false;
    }
}
