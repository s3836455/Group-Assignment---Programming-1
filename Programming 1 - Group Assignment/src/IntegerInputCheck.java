public class IntegerInputCheck {

    public int integerInputCheck(int low, int high) {

        int checkIntegerInput;
        int integerInput = 0;
        
        do {
            checkIntegerInput = 0;
            try{
                integerInput = Main.scanner.nextInt();
                Main.scanner.nextLine();

                if (String.valueOf(integerInput).equals("")) {
                    System.out.println("CANNOT BE EMPTY!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkIntegerInput = 1;

                } else if (!((integerInput >= low) && (integerInput <= high))) {
                    System.out.println("Please only enter a number from " + low + " to " + high + "!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkIntegerInput = 1;
                }
            } catch (Exception e) {
                Main.scanner.nextLine();
                System.out.println("Please only enter a number!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkIntegerInput = 1;
            }
        } while (checkIntegerInput == 1);

        System.out.println();
        
        return integerInput;
    }
}
