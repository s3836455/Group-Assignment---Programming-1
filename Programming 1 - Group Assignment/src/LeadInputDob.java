import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeadInputDob {

    public Date leadInputDob () {

        int checkDate;
        String date;
        Date dob = null;

        do {
            checkDate = 0;
            System.out.print("Enter lead's date of birth (2000-10-01): ");

            date = Main.scanner.nextLine();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            sdf.setLenient(false);

            try {
                dob = sdf.parse(date);

                Date now = new Date();
                int days = (int) ((now.getTime() - dob.getTime()) / (1000 * 60 * 60 * 24));
                int age = (int) (days / 365.25);
                System.out.println("Lead's age: " + age);

                if (date.equals("")) {
                    System.out.println("CANNOT BE EMPTY!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkDate = 1;
                } else {
                    if (age < 0) {
                        System.out.println("Age cannot be less than 0!");
                        System.out.println("Please enter this information again.");
                        System.out.println();
                        checkDate = 1;
                    } else if (age > 130) {
                        System.out.println("Really? This lead can not be that old!");
                        System.out.println("Please enter this information again.");
                        System.out.println();
                        checkDate = 1;
                    }
                }
            } catch (ParseException e) {
                System.out.println("Incorrect date of birth format!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkDate = 1;
            }
        }
        while (checkDate == 1);

        System.out.println("Lead's date of birth: " + date);
        System.out.println();

        return dob;
    }
}
