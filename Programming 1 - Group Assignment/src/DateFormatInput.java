public class DateFormatInput {

    public String dateFormatInput() {

        String dateFormat;
        int dateFormatInput = 0;
        IntegerInputCheck iic = new IntegerInputCheck();

        System.out.println("Please choose a date format in this list:");
        System.out.println("1. 12-31-2000 (MM-dd-yyyy)");
        System.out.println("2. 31-12-2000 (dd-MM-yyyy)");
        System.out.println("3. 2000-12-31 (yyyy-MM-dd)");
        System.out.println();
        System.out.print("Enter the number associated with the chosen date format: ");

        dateFormatInput = iic.integerInputCheck(1,3);

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
