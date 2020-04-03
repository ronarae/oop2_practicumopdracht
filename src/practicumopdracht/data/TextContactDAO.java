package practicumopdracht.data;

import practicumopdracht.models.Contact;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TextContactDAO extends ContactDAO {
    private static final String FILENAME = "resources/ContactBestand.csv";

    @Override
    public boolean save() {
        File contactBestand = new File(FILENAME);
        try (PrintStream input = new PrintStream(contactBestand)) {
            for (Contact c : contact) {
                input.println(c.convertToString());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (Exception e ) {
            System.err.println("Exception");
        }
        return false;
    }

    @Override
    public boolean load() {
        contact = new ArrayList<>();
        String[] contactData;
        ArrayList<String> cleanedContactData;
        File contactBestand = new File(FILENAME);
        try (Scanner input = new Scanner(contactBestand)){
            while(input.hasNextLine()) {
                contactData = input.nextLine().split(",");
                cleanedContactData = new ArrayList<>();
                for (String s : contactData) {
                    cleanedContactData.add(s.trim());
                }
                contact.add(new Contact(cleanedContactData.get(0), LocalDate.parse(cleanedContactData.get(1)),
                        cleanedContactData.get(2), cleanedContactData.get(3), Integer.parseInt(cleanedContactData.get(4)),
                        cleanedContactData.get(5), cleanedContactData.get(6), Integer.parseInt(cleanedContactData.get(7)),
                        Integer.parseInt(cleanedContactData.get(8)),Integer.parseInt(cleanedContactData.get(9))));
            }
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (Exception e) {
            System.err.println("Artikel Exception: " + e);
        }
        return false;
    }
}
