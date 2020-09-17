public class DateFormatInput {

    public String dateFormatInput() {

        int checkDateFormat;
        String dateFormat;
        int dateFormatInput = 0;

        do {
            checkDateFormat = 0;
            System.out.println("Please choose a date format in this list:");
            System.out.println("1. 12-31-2000 (MM-dd-yyyy)");
            System.out.println("2. 31-12-2000 (dd-MM-yyyy)");
            System.out.println("3. 2000-12-31 (yyyy-MM-dd)");
            System.out.println();
            System.out.print("Enter the number associated with the chosen date format: ");

            try{
                dateFormatInput = Main.scanner.nextInt();
                Main.scanner.nextLine();

                if (String.valueOf(dateFormatInput).equals("")) {
                    System.out.println("CANNOT BE EMPTY!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkDateFormat = 1;

                } else if (!((dateFormatInput >= 1) && (dateFormatInput <= 3))) {
                    System.out.println("Please only enter a number from 1 to 4");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkDateFormat = 1;
                }
            } catch (Exception e) {
                Main.scanner.nextLine();
                System.out.println("Please only enter a number!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkDateFormat = 1;
            }
        } while (checkDateFormat == 1);

        if (dateFormatInput == 1) {
            dateFormat = "MM-dd-yyyy";
        } else if (dateFormatInput == 2) {
            dateFormat = "dd-MM-yyyy";
        } else  {
            dateFormat = "yyyy-MM-dd";
        }

        System.out.println("The chosen date format is: " + dateFormat);

        System.out.println();

        return dateFormat;
    }
}
