import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LeadInput implements Inputable{

    @Override
    public void input() {

        LeadInputId lii = new LeadInputId();
        int id = lii.leadInputId();
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
        Lead lead1 = new Lead(id, name, dob, gender, phone, email, address);

        SimpleDateFormat printFormat = new SimpleDateFormat("yyyy-MM-dd");

        String toWrite = "lead_" + String.format("%03d", lead1.getId()) + "," + lead1.getName() + "," + printFormat.format(lead1.getDob()) + "," + lead1.getGender() + "," + lead1.getPhone() + "," + lead1.getEmail() + "," + lead1.displayAddress();

        try {
            FileWriter fWriter = new FileWriter("leads.csv", true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(toWrite + "\n");
            bWriter.close();
            fWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
