import java.util.Scanner;

public class LeadInputGender {

    public boolean leadInputGender () {

        int checkGender;
        boolean gender;
        String genderInput;

        do {
            checkGender = 0;
            System.out.print("Enter 1 for male or 0 for female: ");
            genderInput = Main.scanner.nextLine();

            if (genderInput.equals("")) {
                System.out.println("CANNOT BE EMPTY!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkGender = 1;
            } else if (!(genderInput.equals("0")) && !(genderInput.equals("1"))) {
                System.out.println("Please only enter 0 or 1");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkGender = 1;
            }

        }
        while (checkGender == 1);

        if (genderInput.equals("1")) {
            gender = true;
            System.out.println("Your gender: Male");
        } else {
            gender = false;
            System.out.println("Lead's gender: Female");
        }

        System.out.println();

        return gender;
    }
}
