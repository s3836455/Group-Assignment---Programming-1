public class InteractionInputPotential {

    public String interactionInputPotential() {

        String potential;
        int checkPotential;

        do {
            checkPotential = 0;
            System.out.print("Enter the potential of this interaction (positive/neutral/negative): ");
            potential = Main.scanner.nextLine();

            if (potential.equals("")) {
                System.out.println("CANNOT BE EMPTY!");
                checkPotential = 1;
            }else if (!(potential.equals("positive")) && !(potential.equals("neutral")) && !(potential.equals("negative"))) {
                System.out.println("Interaction's potential can only be positive, neutral, or negative!");
                System.out.println("Please enter this information again.");
                checkPotential = 1;
            }

        }
        while (checkPotential == 1);

        return potential;
    }
}
