import java.util.Scanner;

public class LeadInputStreet {

    public String leadInputStreet() {

        int checkStreet;
        String street;

        do {
            checkStreet = 0;
            System.out.print("Enter lead's street: ");
            street = Main.scanner.nextLine();

            if (street.equals("")) {
                System.out.println("CANNOT BE EMPTY!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkStreet = 1;

            } else if (street.length() > 50) {
                System.out.println("Street cannot be over 50 characters!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkStreet = 1;
            }
        }
        while (checkStreet == 1);

        street = street.toLowerCase();

        StringBuilder upperCasedStreet = new StringBuilder();
        Scanner uppercaseStreet = new Scanner(street);

        while (uppercaseStreet.hasNext()) {
            String word = uppercaseStreet.next();
            upperCasedStreet.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }

        street = upperCasedStreet.toString().trim();

        System.out.println("Lead's street: " + street);

        System.out.println();

        uppercaseStreet.close();

        return street;
    }
}
