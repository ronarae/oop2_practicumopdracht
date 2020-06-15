package practicumopdracht.data;


import practicumopdracht.models.Groep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TextGroepDAO extends GroepDAO {
    private static final String FILENAME = "resources/Groepbestand.txt";

    @Override
    public boolean save() {
        File groepbestand = new File(FILENAME);
        try (PrintStream stream = new PrintStream(groepbestand)) {
            for (Groep g : objects) {
                stream.println(g.convertString());
            }
            return true;
        } catch (FileNotFoundException e ) {
            System.err.println("File not Found");
        } catch (Exception e ) {
            System.err.println("Exception");
        }
        return false;
    }

    @Override
    public boolean load() {
        objects = new ArrayList<>();
        String[] groepData;
        ArrayList<String> cleanedGroepData;
        File groepbestand = new File(FILENAME);
        try (Scanner input = new Scanner(groepbestand)) {
            while(input.hasNextLine()) {
                groepData = input.nextLine().split(",");
                cleanedGroepData = new ArrayList<>();
                for (String s : groepData) {
                    cleanedGroepData.add(s.trim());
                }
                objects.add(new Groep(cleanedGroepData.get(0), LocalDate.parse(cleanedGroepData.get(1))));
            }
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (Exception e ) {
            System.err.println("Groep Exception" + e);
        }
        return false;
    }
}
