import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;

public class InteractionPotentialDisplay {

    public void interactionPotentialDisplay() {

        int checkDateInput;
        String startDateInput;
        String endDateInput;
        Date startDate = null;
        Date endDate = null;
        DateFormatInput df = new DateFormatInput();
        String dateFormat = df.dateFormatInput();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        SimpleDateFormat readsdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat printsdf = new SimpleDateFormat("MMM dd yyyy");
        sdf.setLenient(false);
        int countPositive = 0;
        int countNeutral = 0;
        int countNegative = 0;
        Date date;
        String potential;


        do {
            checkDateInput = 0;
            System.out.print("Enter the start date (" + dateFormat + "): ");
            startDateInput = Main.scanner.nextLine();
            System.out.println();

            System.out.print("Enter the end date (" + dateFormat + "): ");
            endDateInput = Main.scanner.nextLine();
            System.out.println();

            try {
                startDate = sdf.parse(startDateInput);
                endDate = sdf.parse(endDateInput);

                Date now = new Date();

                if ((startDateInput.equals("")) || (endDateInput.equals(""))) {
                    System.out.println("CANNOT BE EMPTY!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkDateInput = 1;
                } else if (((startDate.getTime() - now.getTime()) > 0) || ((endDate.getTime() - now.getTime()) > 0)) {
                    System.out.println("The start date and the end date cannot be later than today!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkDateInput = 1;
                } else if ((startDate.getTime() - now.getTime()) > (endDate.getTime() - now.getTime())) {
                    System.out.println("The start date cannot be later than the end date!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkDateInput = 1;
                }
            } catch (ParseException e) {
                    System.out.println("Incorrect date format!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkDateInput = 1;
            }
        } while (checkDateInput == 1);

        try {
            Scanner x = new Scanner(new File("interactions.csv"));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                x.next();
                date = readsdf.parse(x.next());
                x.next();
                x.next();
                potential = x.next();

                if (((date.getTime() - startDate.getTime()) >= 0) && ((date.getTime() - endDate.getTime()) <= 0)) {
                    if (potential.equals("positive")) {
                        countPositive++;
                    } else if (potential.equals("neutral")) {
                        countNeutral++;
                    } else {
                        countNegative++;
                    }
                }
            }
            x.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("NUMBER OF INTERACTIONS BY POTENTIAL");
        System.out.println("-----------------------------------");
        System.out.println("Input: " + printsdf.format(startDate) + " - " + printsdf.format(endDate));
        System.out.println("|           Positive |            Neutral |           Negative |");
        System.out.println("|" + String.format("% 19d", countPositive) + " |" + String.format("% 19d", countNeutral) + " |" + String.format("% 19d", countNegative) + " |");
        System.out.println();
    }
}
