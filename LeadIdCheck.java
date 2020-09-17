import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeadIdCheck {

    public int leadIdCheck() {

        int checkLeadId;
        int leadIdNumber = 0;

        do {
            checkLeadId = 0;
            System.out.print("Enter the lead's ID: ");

            try {
                leadIdNumber = Main.scanner.nextInt();
                Main.scanner.nextLine();

                if (String.valueOf(leadIdNumber).equals("")) {
                    System.out.println("CANNOT BE EMPTY!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkLeadId = 1;

                }else if (!((leadIdNumber > 0) && (leadIdNumber < 1000))) {
                    System.out.println("Lead's ID number can only be from 1 to 999!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkLeadId = 1;

                }else {
                    try {
                        String sCurrentLine;
                        checkLeadId = 1;

                        BufferedReader br = new BufferedReader(new FileReader("leads.csv"));

                        while ((sCurrentLine = br.readLine()) != null) {
                            if (leadIdNumber == Integer.parseInt(sCurrentLine.substring(5,8))) {
                                checkLeadId = 0;
                            }
                        }
                        if (checkLeadId == 1) {
                            System.out.println("lead_" + String.format("%03d", leadIdNumber) + " does not exist in the lead file!");
                            System.out.println("Please enter this information again.");
                            System.out.println();
                        }

                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e ) {
                Main.scanner.nextLine();
                System.out.println("Please only enter a number!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkLeadId = 1;
            }
        }
        while (checkLeadId == 1);

        System.out.println();

        return leadIdNumber;
    }
}
