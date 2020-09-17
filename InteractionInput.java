import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InteractionInput implements Inputable {

    @Override
    public void input() {

        try{
            BufferedReader br = new BufferedReader(new FileReader("leads.csv"));
            if (br.readLine() == null) {
                System.out.println("The Lead file is empty!");
                System.out.println("Interaction requires the presence of a Lead.");
            }
            else {
                InteractionInputId iii = new InteractionInputId();
                int id = iii.interactionInputId();
                InteractionInputDoi iid = new InteractionInputDoi();
                Date doi = iid.interactionInputDoi();
                InteractionInputLeadId iili = new InteractionInputLeadId();
                String leadId = iili.interactionInputLeadId();
                InteractionInputMethod iim = new InteractionInputMethod();
                String method = iim.interactionInputMethod();
                InteractionInputPotential iip = new InteractionInputPotential();
                String potential = iip.interactionInputPotential();

                Interaction inter1 = new Interaction(id, doi, leadId, method, potential);

                SimpleDateFormat printFormat = new SimpleDateFormat("yyyy-MM-dd");

                String toWrite = "inter_"+ String.format("%03d", inter1.getId()) + "," + printFormat.format(inter1.getDoi()) + "," + inter1.getLeadId() + "," + inter1.getMethod() + "," + inter1.getPotential();

                try {
                    FileWriter fWriter = new FileWriter("interactions.csv", true);
                    BufferedWriter bWriter = new BufferedWriter(fWriter);
                    bWriter.write(toWrite + "\n");
                    bWriter.close();
                    fWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
