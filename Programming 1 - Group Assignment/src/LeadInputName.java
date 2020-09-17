import java.util.Scanner;

public class LeadInputName {

    public String leadInputName() {


        int checkName;
        String name;

        do {
            checkName = 0;
            System.out.print("Enter lead name: ");

            name = Main.scanner.nextLine();

            if (name.equals("")) {
                System.out.println("CANNOT BE EMPTY!");
                System.out.println("Please enter this information again.");
                System.out.println();
                checkName = 1;
            } else {
                for (int i = 0; i < name.length(); i++) {
                    if (!(name.charAt(i) >= 'a' && name.charAt(i) <= 'z') && !(name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') && !(name.charAt(i) == ' ')) {
                        System.out.println("INVALID NAME INPUT!");
                        System.out.println("Please enter this information again.");
                        System.out.println();
                        checkName = 1;
                        break;
                    }
                }
            }
        }
        while (checkName == 1);

        name = name.toLowerCase();

        StringBuilder upperCasedName = new StringBuilder();
        Scanner uppercaseName = new Scanner(name);

        while (uppercaseName.hasNext()) {
            String word = uppercaseName.next();
            upperCasedName.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }

        name = upperCasedName.toString().trim();

        System.out.println("Lead's name: " + name);

        System.out.println();

        uppercaseName.close();

        return name;
    }
}
