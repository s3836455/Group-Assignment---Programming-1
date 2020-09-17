import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InteractionIdCheck {

    public int interIdCheck() {

        int checkInterId;
        int interIdNumber = 0;

        do {
            checkInterId = 0;
            System.out.print("Enter the interaction's ID: ");
            try {
                interIdNumber = Main.scanner.nextInt();
                Main.scanner.nextLine();

                if (String.valueOf(interIdNumber).equals("")) {
                    System.out.println("CANNOT BE EMPTY!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkInterId = 1;

                }else if (!((interIdNumber > 0) && (interIdNumber < 1000))) {
                    System.out.println("Interaction's ID number can only be from 1 to 999!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkInterId = 1;

                }else {
                    try {
                        String sCurrentLine;
                        checkInterId = 1;

                        BufferedReader br = new BufferedReader(new FileReader("interactions.csv"));

                        while ((sCurrentLine = br.readLine()) != null) {
                            if (interIdNumber == Integer.parseInt(sCurrentLine.substring(6,9))) {
                                checkInterId = 0;
                            }
                        }
                        if (checkInterId == 1) {
                            System.out.println("inter_" + String.format("%03d", interIdNumber) + " does not exist in the interaction file!");
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
                checkInterId = 1;
            }
        }
        while (checkInterId == 1);

        System.out.println();

        return interIdNumber;
    }
}
