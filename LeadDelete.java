import java.io.*;
import java.util.Scanner;

public class LeadDelete implements Deletable{

    public void delete() {

        //checkIdInput
        LeadIdCheck idCheck = new LeadIdCheck();
        int leadIdToDelete = idCheck.leadIdCheck();

        LeadExistInInteraction leii = new LeadExistInInteraction();

        if (leii.leadExistInInteraction("Lead's ID: lead_" + String.format("%03d", leadIdToDelete))) {
            System.out.println("This lead is associated with one or more interactions!");
            System.out.println("Please go to Interaction Manager to delete associated interactions before deleting this lead.");
        } else {
            File originalFile = new File("leads.csv");
            File tempFile = new File("tempLeads.csv");
            String id1;
            String name1;
            String dob1;
            String gender1;
            String phone1;
            String email1;
            String address1;

            try {
                FileWriter fWriter = new FileWriter("tempLeads.csv",true);
                BufferedWriter bWriter = new BufferedWriter(fWriter);
                PrintWriter pWriter = new PrintWriter(bWriter);
                Scanner x = new Scanner(new File("leads.csv"));
                x.useDelimiter("[,\n]");


                while (x.hasNext()) {
                    id1 = x.next();
                    name1 = x.next();
                    dob1 = x.next();
                    gender1 = x.next();
                    phone1 = x.next();
                    email1 = x.next();
                    address1 = x.next();


                    if (!(id1.equals("lead_" + String.format("%03d", leadIdToDelete)))) {
                        pWriter.write(id1 + "," + name1 + "," + dob1 + "," + gender1 + "," + phone1 + "," + email1 + "," + address1);
                        pWriter.write("\n");
                    }
                }
                x.close();
                pWriter.flush();
                pWriter.close();
                bWriter.close();
                fWriter.close();
                originalFile.delete();
                File changeName = new File("leads.csv");
                tempFile.renameTo(changeName);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
