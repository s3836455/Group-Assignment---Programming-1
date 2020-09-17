public class InteractionInputMethod {

    public String interactionInputMethod() {

        int checkMethod;
        String method;
        int methodInput = 0;

        do {
            checkMethod = 0;
            System.out.println("List of contact methods:");
            System.out.println("1. Email");
            System.out.println("2. Telephone");
            System.out.println("3. Face to face");
            System.out.println("4. Social media");
            System.out.println();
            System.out.print("Enter the number associated with the correct contact method: ");

            try {

                methodInput = Main.scanner.nextInt();
                Main.scanner.nextLine();

                if (String.valueOf(methodInput).equals("")) {
                    System.out.println("CANNOT BE EMPTY!");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkMethod = 1;

                } else if (!((methodInput >= 1) && (methodInput <= 4))) {
                    System.out.println("Please only enter a number from 1 to 4");
                    System.out.println("Please enter this information again.");
                    System.out.println();
                    checkMethod = 1;
                }
            } catch (Exception e) {
                Main.scanner.nextLine();
                System.out.println("Please only enter a number!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkMethod = 1;
            }

        } while (checkMethod == 1);

        if (methodInput == 1) {
            method = "Email";
        } else if (methodInput == 2) {
            method = "Telephone";
        } else if (methodInput == 3) {
            method = "Face to face";
        } else {
            method = "Social media";
        }

        System.out.println("The chosen contact method: " + method);

        System.out.println();

        return method;
    }
}
