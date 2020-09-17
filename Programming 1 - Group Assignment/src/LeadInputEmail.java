import java.util.Scanner;

public class LeadInputEmail {

    public String leadInputEmail() {

        int checkEmail;
        String email;

        do {
            checkEmail = 0;
            System.out.print("Enter lead's email: ");
            email = Main.scanner.nextLine();

            if (email.equals("")) {
                System.out.println("CANNOT BE EMPTY!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkEmail = 1;
            } else if (!(email.matches("(.*)@gmail.com"))) {
                System.out.println("Incorrect email!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkEmail = 1;
            }
        }
        while (checkEmail == 1);

        System.out.println("Lead's email: " + email);

        System.out.println();

        return email;
    }
}
