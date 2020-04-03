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
        File groepBestand = new File(FILENAME);
        try (PrintStream stream = new PrintStream(groepBestand)) {
            for (Groep g : groep) {
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
        groep = new ArrayList<>();
        String[] groepData;
        ArrayList<String> cleanedGroepData;
        File groepBestand = new File(FILENAME);
        try (Scanner input = new Scanner(groepBestand)) {
            while(input.hasNextLine()) {
                groepData = input.nextLine().split(",");
                cleanedGroepData = new ArrayList<>();
                for (String s : groepData) {
                    cleanedGroepData.add(s.trim());
                }
                groep.add(new Groep(cleanedGroepData.get(0), LocalDate.parse(cleanedGroepData.get(1))));
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
