import java.io.FileNotFoundException;
import java.util.Date;

public class Lead {
    private int id;
    private String name;
    private Date dob;
    private boolean gender;
    private String phone;
    private String email;
    private Address address;

    public Lead(){}

    public Lead(int id, String name, Date dob, boolean gender, String phone, String email, Address address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public boolean getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String displayAddress() {
        return this.address.getHouseNumber() + " " + this.address.getStreet();
    }


    public void getLeadsInput () {

        char checkRepeat = 0;
        LeadInput li = new LeadInput();
        Repeat r = new Repeat();

        do {

            System.out.println("Please enter the information for the lead!");
            System.out.println();
            li.input();

            System.out.println("Do you want to enter another lead's information? (Y/N): ");
            checkRepeat = r.repeat();

        } while ((checkRepeat == 'Y') || (checkRepeat == 'y'));
    }

    public void displayLeadsAll () throws FileNotFoundException {

        LeadDisplay lda = new LeadDisplay();
        System.out.println("Below are all the recorded leads:");
        System.out.println();
        lda.displayAll();
    }

    public void displayLeadsOne () throws FileNotFoundException {

        char checkRepeat = 0;
        LeadDisplay ldo = new LeadDisplay();
        Repeat r = new Repeat();

        do {
            System.out.println("Please choose your the lead's record you want to DISPLAY!");
            System.out.println();
            ldo.displayOne();

            System.out.println("Do you want to display another lead's information? (Y/N): ");
            checkRepeat = r.repeat();

        } while ((checkRepeat == 'Y') || (checkRepeat == 'y'));
    }

    public void deleteLeads() {

        char checkRepeat = 0;
        LeadDelete ld = new LeadDelete();
        Repeat r = new Repeat();

        do {
            System.out.println("Please choose your the lead's record you want to DELETE!");
            System.out.println();
            ld.delete();

            System.out.println("Do you want to delete another lead's information? (Y/N): ");
            checkRepeat = r.repeat();

        } while ((checkRepeat == 'Y') || (checkRepeat == 'y'));
    }

    public void updateLeads() {

        char checkRepeat = 0;
        LeadUpdate ld = new LeadUpdate();
        Repeat r = new Repeat();

        do {
            System.out.println("Please choose your the lead's record you want to UPDATE!");
            System.out.println();
            ld.update();

            System.out.println("Do you want to update another lead's information? (Y/N): ");
            checkRepeat = r.repeat();

        } while ((checkRepeat == 'Y') || (checkRepeat == 'y'));
    }

    public void displayLeadsByAges() {

        LeadAgeDisplay lad = new LeadAgeDisplay();
        lad.leadAgeDisplay();
    }
}



