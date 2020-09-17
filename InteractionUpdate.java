import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InteractionUpdate implements Updatable {

    public void update () {

        //checkIdInput
        InteractionIdCheck idCheck = new InteractionIdCheck();
        int interIdToUpdate = idCheck.interIdCheck();

        InteractionInputDoi iid = new InteractionInputDoi();
        Date doi = iid.interactionInputDoi();
        InteractionInputLeadId iili = new InteractionInputLeadId();
        String leadId = iili.interactionInputLeadId();
        InteractionInputMethod iim = new InteractionInputMethod();
        String method = iim.interactionInputMethod();
        InteractionInputPotential iip = new InteractionInputPotential();
        String potential = iip.interactionInputPotential();

        Interaction inter1 = new Interaction(interIdToUpdate, doi, leadId, method, potential);

        SimpleDateFormat printFormat = new SimpleDateFormat("yyyy-MM-dd");

        String toWrite = "inter_"+ String.format("%03d", inter1.getId()) + "," + printFormat.format(inter1.getDoi()) + "," + inter1.getLeadId() + "," + inter1.getMethod() + "," + inter1.getPotential();

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

                if (!(id1.equals("inter_" + String.format("%03d", interIdToUpdate)))) {
                    pWriter.write(id1 + "," + doi1 + "," + leadId1 + "," + method1 + "," + potential1);
                    pWriter.write("\n");
                } else {
                    pWriter.write(toWrite);
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
