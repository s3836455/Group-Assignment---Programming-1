import java.io.*;
import java.util.Scanner;

public class LeadExistInInteraction {

    public boolean leadExistInInteraction(String leadId) {

        boolean exist = false;
        String leadId1;
        try {
            Scanner x = new Scanner(new File("interactions.csv"));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                x.next();
                x.next();
                leadId1 = x.next();
                x.next();
                x.next();

                if (leadId == leadId1) {
                    exist = true;
                    break;
                }
            }

            x.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return exist;
    }
}
