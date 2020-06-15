package practicumopdracht.data;

import practicumopdracht.models.Groep;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BinaryGroepDAO extends GroepDAO {

    private static final String FILENAME = "resources/Groepbestand.dat";

    @Override
    public boolean save() {
        try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILENAME)))) {
            for (Groep g : objects) {
                output.writeUTF(g.convertString());
            }
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        } catch (Exception e ) {
            System.err.println("Exception");
        }
        return false;
    }

    @Override
    public boolean load() {
        objects = new ArrayList<>();
        String[] data;
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(FILENAME)))) {
            while (input.available() > 0) {
                data = input.readUTF().split(",");
                for (int i = 0; i < data.length; i++) {
                    data[i] = data[i].trim();
                }
                objects.add(new Groep(data[0], LocalDate.parse(data[1])));
            }
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (EOFException e ) {
            System.err.println("End of File reached");
        } catch (IOException e) {
            System.err.println("IO Exception");
        } catch (Exception e) {
            System.err.println("Exception");
        }
        return false;
    }
}
