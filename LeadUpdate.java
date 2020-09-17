import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LeadUpdate {

    public void update() {

        //checkIdInput
        LeadIdCheck idCheck = new LeadIdCheck();
        int leadIdToUpdate = idCheck.leadIdCheck();

        LeadInputName lin = new LeadInputName();
        String name = lin.leadInputName();
        LeadInputDob lid = new LeadInputDob();
        Date dob = lid.leadInputDob();
        LeadInputGender lig = new LeadInputGender();
        boolean gender = lig.leadInputGender();
        LeadInputPhone lip = new LeadInputPhone();
        String phone = lip.leadInputPhone();
        LeadInputEmail lie = new LeadInputEmail();
        String email = lie.leadInputEmail();
        LeadInputHouseNumber lihn = new LeadInputHouseNumber();
        String houseNumber = lihn.leadInputHouseNumber();
        LeadInputStreet lis = new LeadInputStreet();
        String street = lis.leadInputStreet();

        Address address = new Address(houseNumber, street);
        Lead lead1 = new Lead(leadIdToUpdate, name, dob, gender, phone, email, address);

        SimpleDateFormat printFormat = new SimpleDateFormat("yyyy-MM-dd");

        String toWrite = "lead_" + String.format("%03d", lead1.getId()) + "," + lead1.getName() + "," + printFormat.format(lead1.getDob()) + "," + lead1.getGender() + "," + lead1.getPhone() + "," + lead1.getEmail() + "," + lead1.displayAddress();

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

                if (!(id1.equals("lead_" + String.format("%03d", leadIdToUpdate)))) {
                    pWriter.write(id1 + "," + name1 + "," + dob1 + "," + gender1 + "," + phone1 + "," + email1 + "," + address1);
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
            File changeName = new File("leads.csv");
            tempFile.renameTo(changeName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}