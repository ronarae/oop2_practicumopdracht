package practicumopdracht.data;

import practicumopdracht.models.Contact;
import practicumopdracht.models.Groep;

import java.io.*;
import java.util.ArrayList;

public class ObjectContactDAO extends ContactDAO {
    private static final String FILENAME = "resources/ContactBestand.csv";

    @Override
    public boolean save() {
        File file = new File(FILENAME);
        try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (Contact c : contact) {
                output.writeObject(c);
            }
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (EOFException e) {
            System.err.println("End of File reached");
        } catch (IOException e) {
            System.err.println("IO Exception");
        } catch (Exception e) {
            System.err.println("Exception");
        }
        return false;
    }

    @Override
    public boolean load() {
        contact = new ArrayList<>();
        File file = new File(FILENAME);
        try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (true) {
                contact.add((Contact) input.readObject());
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
