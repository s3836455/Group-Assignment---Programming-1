import java.io.*;
import java.util.Date;

public class Interaction {
    private int id;
    private Date doi;
    private String leadId;
    private String method;
    private String potential;

    public Interaction(){}

    public Interaction(int id, Date doi, String leadId, String method, String potential) {
        this.id = id;
        this.doi = doi;
        this.leadId = leadId;
        this.method = method;
        this.potential = potential;
    }

    public int getId() {
        return id;
    }

    public Date getDoi() {
        return doi;
    }

    public String getLeadId() {
        return leadId;
    }

    public String getMethod() {
        return method;
    }

    public String getPotential() {
        return potential;
    }

    public void getIntersInput () {

        char checkRepeat = 0;
        InteractionInput ii = new InteractionInput();
        Repeat r = new Repeat();

        do {
            System.out.println("Please enter the information for the interaction!");
            System.out.println();
            ii.input();

            try {
                BufferedReader br = new BufferedReader(new FileReader("interactions.csv"));
                if (br.readLine() == null) {
                    checkRepeat = 'N';
                } else {
                    System.out.println("Do you want to enter another interaction's information? (Y/N): ");
                    checkRepeat = r.repeat();
                }

                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while ((checkRepeat == 'Y') || (checkRepeat == 'y'));
    }

    public void displayIntersAll () throws FileNotFoundException {

        InteractionDisplay ida = new InteractionDisplay();
        System.out.println("Below are all the recorded interactions:");
        System.out.println();
        ida.displayAll();
    }

    public void displayIntersOne () throws FileNotFoundException {

        char checkRepeat = 0;
        InteractionDisplay ido = new InteractionDisplay();
        Repeat r = new Repeat();

        do {
            System.out.println("Please choose your the interaction's record you want to DISPLAY!");
            System.out.println();
            ido.displayOne();

            System.out.println("Do you want to display another interaction's information? (Y/N): ");
            checkRepeat = r.repeat();

        } while ((checkRepeat == 'Y') || (checkRepeat == 'y'));
    }

    public void deleteInters() {

        char checkRepeat = 0;
        InteractionDelete id = new InteractionDelete();
        Repeat r = new Repeat();

        do {
            System.out.println("Please choose your the interaction's record you want to DELETE!");
            System.out.println();
            id.delete();

            System.out.println("Do you want to delete another interaction's information? (Y/N): ");
            checkRepeat = r.repeat();

        } while ((checkRepeat == 'Y') || (checkRepeat == 'y'));
    }

    public void updateInters() {

        char checkRepeat = 0;
        InteractionUpdate id = new InteractionUpdate();
        Repeat r = new Repeat();

        do {
            System.out.println("Please choose your the interaction's record you want to UPDATE!");
            System.out.println();
            id.update();

            System.out.println("Do you want to update another interaction's information? (Y/N): ");
            checkRepeat = r.repeat();

        } while ((checkRepeat == 'Y') || (checkRepeat == 'y'));
    }
}
