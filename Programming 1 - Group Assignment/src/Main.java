import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class  Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        File fileLead = new File("leads.csv");
        if (!fileLead.exists()) {
            try {
                fileLead.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        File fileInteraction = new File("interactions.csv");
        if (!fileInteraction.exists()) {
            try {
                fileInteraction.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int checkOption;
        int checkLeadOption;
        int checkInterOption;
        int checkReportOption;
        int option = 0;
        int leadOption = 0;
        int interOption = 0;
        int reportOption = 0;
        IntegerInputCheck iic = new IntegerInputCheck();
        Lead l = new Lead();
        Interaction i = new Interaction();
        ReportsAndStatistics ras = new ReportsAndStatistics();

        //MAIN
        do {
            checkOption = 0;

            System.out.println("---------");
            System.out.println("MAIN MENU");
            System.out.println("---------");
            System.out.println("1.Managing leads.");
            System.out.println("2.Managing interactions.");
            System.out.println("3.Reporting and statistics.");
            System.out.println("4.Exit the program.\n");
            System.out.print("Please enter the number associated with your choice: ");

            option = iic.integerInputCheck(1,4);

            //MANAGING LEADS
            if (option == 1) {
                do {
                    checkLeadOption = 0;

                    System.out.println("--------------");
                    System.out.println("MANAGING LEADS");
                    System.out.println("--------------");
                    System.out.println("1.View a list of leads with all details displayed.");
                    System.out.println("2.View a lead of your choice with all details displayed.");
                    System.out.println("3.Add a lead (Enter all lead's detail).");
                    System.out.println("4.Delete a lead (Enter lead's id).");
                    System.out.println("5.Update a lead (Enter lead's id).");
                    System.out.println("6.Go to main menu.\n");
                    System.out.print("Please enter your option: ");

                    leadOption = iic.integerInputCheck(1,6);

                    if (leadOption == 1) {
                        // method to view list of leads
                        l.displayLeadsAll();
                        checkLeadOption = 1;

                    } else if (leadOption == 2) {
                        // method to view a lead of your choice
                        l.displayLeadsOne();
                        checkLeadOption = 1;

                    } else if (leadOption == 3) {
                        //method to add a new lead
                        l.getLeadsInput();
                        checkLeadOption = 1;

                    } else if (leadOption == 4) {
                        // method to delete a lead of your choice
                        l.deleteLeads();
                        checkLeadOption = 1;

                    } else if (leadOption == 5) {
                        // method to update a lead of your choice
                        l.updateLeads();
                        checkLeadOption = 1;

                    } else {
                        checkOption = 1;
                    }
                }
                while (checkLeadOption == 1);



                // MANAGING INTERACTIONS
            } else if (option == 2) {
                do{
                    checkInterOption = 0;

                    System.out.println("---------------------");
                    System.out.println("MANAGING INTERACTIONS");
                    System.out.println("---------------------");
                    System.out.println("1.View a list of interactions with all details displayed.");
                    System.out.println("2.View a interaction of your choice with all details displayed.");
                    System.out.println("3.Add an interaction (Enter interaction information).");
                    System.out.println("4.Delete an interaction (Enter interaction id).");
                    System.out.println("5.Update an interaction (Enter interaction id).");
                    System.out.println("6.Go to main menu.\n");
                    System.out.print("Please enter your option: ");

                    interOption = iic.integerInputCheck(1,5);

                    if (interOption == 1) {
                        //method to view list of interactions
                        i.displayIntersAll();
                        checkInterOption = 1;

                    } else if (interOption == 2) {
                        //method to view one interaction of your choice
                        i.displayIntersOne();
                        checkInterOption = 1;

                    } else if (interOption == 3) {
                        //method to add a new interaction
                        i.getIntersInput();
                        checkInterOption = 1;

                    } else if (interOption == 4) {
                        //method to delete an interaction of your choice
                        i.deleteInters();
                        checkInterOption = 1;

                    } else if (interOption == 5) {
                        //method to update an interaction of your choice
                        i.updateInters();
                        checkInterOption = 1;

                    } else {
                        checkOption = 1;
                    }
                }
                while(checkInterOption == 1);


                // INTERACTION
            } else if (option == 3) {
                do{
                    checkReportOption = 0;

                    System.out.println("------------------------");
                    System.out.println("REPORTING AND STATISTICS");
                    System.out.println("------------------------");
                    System.out.println("1.View a summary report that contains all number of leads by ages (Enter start date and end date).");
                    System.out.println("2.View a summary report that contains all number of interactions by potential(Enter start date and end date).");
                    System.out.println("3.View a summary report that contains all number of interactions by month (Enter start date and end date).");
                    System.out.println("4.Go to main menu.\n");
                    System.out.print("Please enter your option: ");

                    reportOption = iic.integerInputCheck(1,4);

                    if (reportOption == 1) {
                        //method to view a report of leads by ages
                        ras.displayLeadsByAge();
                        checkReportOption = 1;

                    } else if(reportOption == 2) {
                        //method to view a report of interactions by potential
                        ras.displayIntersByPotential();
                        checkReportOption = 1;

                    } else if (reportOption == 3) {
                        //method to view a report of interactions by month
                        ras.displayIntersByMonth();
                        checkReportOption = 1;

                    } else {
                        checkOption = 1;
                    }
                }
                while(checkReportOption == 1);

            } else if (option == 4) {
                System.out.println("Program finished!");
                System.out.println("Goodbye!");
            }
        }
        while (checkOption == 1);
    }
}


