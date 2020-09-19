import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class LeadAgeDisplay {

    public void leadAgeDisplay() {

        Date dob1;
        int age;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        int count_0to10 = 0;
        int count_10to20 = 0;
        int count_20to60 = 0;
        int count_over60 = 0;

        try {
            Scanner x = new Scanner(new File("leads.csv"));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                x.next();
                x.next();
                dob1 = sdf.parse(x.next());
                x.next();
                x.next();
                x.next();
                x.next();

                age = (int) ((now.getTime() - dob1.getTime()) / (1000 * 60 * 60 * 24) / 365.25);

                if ((age >= 0) && (age < 10)) {
                    count_0to10++;
                } else if ((age >= 10) && (age < 20)) {
                    count_10to20++;
                } else if ((age >= 20) && (age < 60)) {
                    count_20to60++;
                } else {
                    count_over60++;
                }
            }
            x.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("NUMBER OF LEADS BY AGES");
        System.out.println("-----------------------");
        System.out.println("| " + String.format("%1$18s", "0-10(years old)") + " | " + String.format("%1$18s", "10-20(years old)") + " | " + String.format("%1$18s", "20-60(years old)") + " | " + String.format("%1$18s", "over 60(years old)") + " |");
        System.out.println("| " + String.format("%1$18d", count_0to10) + " | " + String.format("%1$18d", count_10to20) + " | " + String.format("%1$18d", count_20to60) + " | " + String.format("%1$18d", count_over60) + " |");
        System.out.println();
    }
}
