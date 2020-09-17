import java.util.Scanner;

public class LeadInputPhone {

    public String leadInputPhone () {

        int checkPhone;
        String phone;

        do {
            checkPhone = 0;
            System.out.print("Enter lead's phone number: ");
            phone = Main.scanner.nextLine();

            if (phone.equals("")) {
                System.out.println("CANNOT BE EMPTY!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkPhone = 1;
            } else {
                for (int i = 0; i < phone.length(); i++) {
                    if (!(phone.charAt(i) >= '0' && phone.charAt(i) <= '9')) {
                        System.out.println("INVALID NAME INPUT!");
                        System.out.println("Please enter this information again.");
                        System.out.println();
                        checkPhone = 1;
                        break;
                    }
                }
            }

            if (phone.length() != 10 && phone.length() != 11) {
                System.out.println("Incorrect phone number!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkPhone = 1;
            }
        }
        while (checkPhone == 1);

        System.out.println("Lead's phone number: " + phone);

        System.out.println();

        return phone;
    }
}
