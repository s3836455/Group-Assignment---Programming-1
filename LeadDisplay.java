import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeadDisplay implements Displayable{

    public void displayAll() throws FileNotFoundException {

        Scanner listOfLeads = new Scanner(new File("leads.csv"));
        listOfLeads.useDelimiter("[,\n]");
        String gender;

        while (listOfLeads.hasNext()) {
            System.out.println("Lead's ID           : " + listOfLeads.next().substring(5,8));
            System.out.println("Lead's Name         : " + listOfLeads.next());
            System.out.println("Lead's Date of Birth: " + listOfLeads.next());
            if (listOfLeads.next().equals("true")) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            System.out.println("Lead's Gender       : " + gender);
            System.out.println("Lead's Phone Number : " + listOfLeads.next());
            System.out.println("Lead's Email        : " + listOfLeads.next());
            System.out.println("Lead's Address      : " + listOfLeads.next());
            System.out.println();
        }
        listOfLeads.close();

        System.out.println();
    }

    public void displayOne() throws FileNotFoundException{

        Scanner listOfLeads = new Scanner(new File("leads.csv"));
        listOfLeads.useDelimiter("[,\n]");
        String id;
        String gender;
        LeadIdCheck idCheck = new LeadIdCheck();
        int leadIdToDisplay = idCheck.leadIdCheck();

        while (listOfLeads.hasNext()) {

            id = listOfLeads.next();
            if ((id.equals("lead_" + String.format("%03d", leadIdToDisplay)))) {
                System.out.println("Lead's ID           : " + id.substring(5,8));
                System.out.println("Lead's Name         : " + listOfLeads.next());
                System.out.println("Lead's Date of Birth: " + listOfLeads.next());
                if (listOfLeads.next().equals("true")) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                System.out.println("Lead's Gender       : " + gender);
                System.out.println("Lead's Phone Number : " + listOfLeads.next());
                System.out.println("Lead's Email        : " + listOfLeads.next());
                System.out.println("Lead's Address      : " + listOfLeads.next());
                System.out.println();
                break;
            } else {
                listOfLeads.next();
                listOfLeads.next();
                listOfLeads.next();
                listOfLeads.next();
                listOfLeads.next();
                listOfLeads.next();
            }
        }
        listOfLeads.close();
    }
}