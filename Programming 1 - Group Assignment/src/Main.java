
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        File fileLead = new File("leads.csv");
        if (!fileLead.exists()) {
            try {
                fileLead.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        File fileInteraction = new File("interactions.csv");
        if (!fileInteraction.exists()) {
            try {
                fileInteraction.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        Lead l = new Lead();
//        l.getLeadsInput();
//        l.displayLeadsAll();
//        l.displayLeadsOne();
//        l.deleteLeads();
//        l.updateLeads();

        Interaction i = new Interaction();
        i.getIntersInput();
        i.displayIntersAll();
        i.displayIntersOne();
        i.deleteInters();
        i.updateInters();
    }
}
