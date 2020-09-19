public class ReportsAndStatistics {

    public void displayLeadsByAge() {

        LeadAgeDisplay lad = new LeadAgeDisplay();
        lad.leadAgeDisplay();
    }

    public void displayIntersByPotential() {

        char checkRepeat = 0;
        InteractionPotentialDisplay lpd = new InteractionPotentialDisplay();
        Repeat r = new Repeat();

        do {
            System.out.println("Please choose the your desired period of time you want to DISPLAYY!");
            System.out.println();
            lpd.interactionPotentialDisplay();

            System.out.println("Do you want to display another set of interactions by potential (Y/N): ");
            checkRepeat = r.repeat();

        } while ((checkRepeat == 'Y') || (checkRepeat == 'y'));
    }

    public void displayIntersByMonth() {

        char checkRepeat = 0;
        InteractionMonthDisplay lmd = new InteractionMonthDisplay();
        Repeat r = new Repeat();

        do {
            System.out.println("Please choose the your desired period of time you want to DISPLAY!");
            System.out.println();
            lmd.interactionMonthDisplay();

            System.out.println("Do you want to display another set of interactions by month (Y/N): ");
            checkRepeat = r.repeat();

        } while ((checkRepeat == 'Y') || (checkRepeat == 'y'));
    }
}
