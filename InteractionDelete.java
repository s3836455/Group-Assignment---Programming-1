import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class InteractionDelete implements Deletable {

    public void delete () {

        //checkIdInput
        InteractionIdCheck idCheck = new InteractionIdCheck();
        int interIdToDelete = idCheck.interIdCheck();

        File originalFile = new File("interactions.csv");
        File tempFile = new File("tempInteractions.csv");
        String id1;
        String doi1;
        String leadId1;
        String method1;
        String potential1;

        try {
            FileWriter fWriter = new FileWriter("tempInteractions.csv",true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            PrintWriter pWriter = new PrintWriter(bWriter);
            Scanner x = new Scanner(new File("interactions.csv"));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                id1 = x.next();
                doi1 = x.next();
                leadId1 = x.next();
                method1 = x.next();
                potential1 = x.next();

                if (!(id1.equals("inter_" + String.format("%03d", interIdToDelete)))) {
                    pWriter.write(id1 + "," + doi1 + "," + leadId1 + "," + method1 + "," + potential1);
                    pWriter.write("\n");
                }
            }
            x.close();
            pWriter.flush();
            pWriter.close();
            bWriter.close();
            fWriter.close();
            originalFile.delete();
            File changeName = new File("interactions.csv");
            tempFile.renameTo(changeName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}
