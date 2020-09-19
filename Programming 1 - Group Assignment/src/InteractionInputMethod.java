public class InteractionInputMethod {

    public String interactionInputMethod() {

        int checkMethod;
        String method;
        int methodInput = 0;
        IntegerInputCheck iic = new IntegerInputCheck();

        System.out.println("List of contact methods:");
        System.out.println("1. Email");
        System.out.println("2. Telephone");
        System.out.println("3. Face to face");
        System.out.println("4. Social media");
        System.out.println();
        System.out.print("Enter the number associated with the correct contact method: ");

        methodInput = iic.integerInputCheck(1,4);

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
