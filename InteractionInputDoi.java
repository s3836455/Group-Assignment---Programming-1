import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InteractionInputDoi {

    public Date interactionInputDoi() {

        int checkDate;
        String date;
        Date doi = null;

        do {
            checkDate = 0;
            System.out.print("Enter the date of interaction (2000-10-01): ");

            date = Main.scanner.nextLine();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            sdf.setLenient(false);

            try {
                doi = sdf.parse(date);

                Date now = new Date();
                long time = (long) (now.getTime() - doi.getTime());

                if (date.equals("")) {
                    System.out.println("CANNOT BE EMPTY!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkDate = 1;
                } else if (time < 0){
                    System.out.println("The date of interaction cannot be later than today!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkDate = 1;
                }
            } catch (ParseException e) {
                System.out.println("Incorrect date of interaction format!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkDate = 1;
            }
        }
        while (checkDate == 1);

        System.out.println("Interaction's date of interaction: " + date);
        System.out.println();

        return doi;
    }
}
