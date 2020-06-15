package practicumopdracht.data;

import practicumopdracht.models.Groep;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BinaryGroepDAO extends GroepDAO {

    private static final String FILENAME = "resources/Groepbestand.dat";

    @Override
    public boolean save() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(FILENAME))) {
            for (Groep groep : objects) {
                dataOutputStream.writeUTF(groep.getGroepNaam() + " , " + groep.getDatumToegevoegd());
            }
            return true;
        } catch (FileNotFoundException ex) {
            System.err.println("GroepFile niet gevonden");
        } catch (NullPointerException ex) {
            System.err.println("Groep object is null");
        } catch (IOException ex) {
            System.err.println("IO Exception binary");
        } catch (Exception ex) {
            System.err.println("Vak exception: " + ex);
        }
        return false;
    }

    @Override
    public boolean load() {
        objects = new ArrayList<>();
        String[] data;

        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(FILENAME)))) {
            while (dataInputStream.available() > 0) {
                data = dataInputStream.readUTF().split(",");

                for (int i = 0; i < data.length; i++) {
                    data[i] = data[i].trim();
                }
                objects.add(new Groep(data[0], LocalDate.parse(data[1])));
            }
            return true;
        } catch (FileNotFoundException ex) {
            System.err.println("Groep niet gevonden");
        } catch (EOFException ex) {
            System.err.println("Alle data is gelezen ");
        } catch (IOException e) {
            System.err.println("IO Exception");
        } catch (Exception ex) {
            System.err.println("Groep exception: " + ex);
        }
        return false;
    }
}
