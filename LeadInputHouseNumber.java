import java.util.Scanner;

public class LeadInputHouseNumber {

    public String leadInputHouseNumber() {

        int checkHouseNumber;
        String houseNumber;

        do {
            checkHouseNumber = 0;
            System.out.print("Enter lead's house number: ");
            houseNumber = Main.scanner.nextLine();

            if (houseNumber.equals("")) {
                System.out.println("CANNOT BE EMPTY!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkHouseNumber = 1;
            } else {
                for (int i = 0; i < houseNumber.length(); i++) {
                    if (!(houseNumber.charAt(i) >= '0' && houseNumber.charAt(i) <= '9')) {
                        System.out.println("Please only enter number for lead's house number!");
                        System.out.println("Please enter this information again.");
                        System.out.println();
                        checkHouseNumber = 1;
                        break;
                    }
                }
            }

            int getLength = houseNumber.length();

            if (!(getLength >= 1 && getLength <= 5)) {
                System.out.println("Incorrect house number!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkHouseNumber = 1;
            }
        }
        while (checkHouseNumber == 1);

        System.out.println("Lead's house number: " + houseNumber);

        System.out.println();

        return houseNumber;
    }
}
