import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InteractionMonthDisplay {

    public void interactionMonthDisplay() {

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
        SimpleDateFormat printFormat = new SimpleDateFormat("MMM yyyy");
        sdf.setLenient(false);
        Date date;

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

        int startYear = startDate.getYear() + 1900;
        int endYear = endDate.getYear() + 1900;
        int differenceInYear = endYear - startYear + 1;
        int[][] count = new int[differenceInYear][12];
        String[][] countDate = new String[differenceInYear][12];
        int dateYear;
        int dateMonth;

        try {
            Scanner x = new Scanner(new File("interactions.csv"));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                x.next();
                date = readsdf.parse(x.next());
                x.next();
                x.next();
                x.next();

                dateYear = date.getYear() + 1900;
                dateMonth = date.getMonth();

                if (((date.getTime() - startDate.getTime()) >= 0) && ((date.getTime() - endDate.getTime()) <= 0)) {
                    for (int a = 0; a < differenceInYear; a++) {
                        for (int b = 0; b < 12; b++) {
                            if (((a+startYear) == dateYear) && (b == dateMonth)) {
                                count[a][b]++;
                                countDate[a][b] = printFormat.format(date);
                            }
                        }
                    }
                }
            }
            x.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("NUMBER OF INTERACTIONS BY MONTH");
        System.out.println("-------------------------------");
        System.out.println("Input: " + printsdf.format(startDate) + " - " + printsdf.format(endDate));

        for (int a = 0; a < differenceInYear; a++) {
            for (int b = 0; b < 12; b++) {
                if (count[a][b] > 0) {
                    System.out.print("| " + String.format("%1$10s", countDate[a][b]) + " |");
                }
            }
        }
        System.out.print("\n");

        for (int a = 0; a < differenceInYear; a++) {
            for (int b = 0; b < 12; b++) {
                if (count[a][b] > 0) {
                    System.out.print("| " + String.format("%1$10d", count[a][b]) + " |");
                }
            }
        }
        System.out.println("\n");
    }
}
