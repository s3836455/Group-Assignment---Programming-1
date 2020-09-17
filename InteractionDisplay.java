import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InteractionDisplay implements Displayable{

    public void displayAll () throws FileNotFoundException {

        Scanner listOfInter = new Scanner(new File("interactions.csv"));
        listOfInter.useDelimiter("[,\n]");

        while (listOfInter.hasNext()) {
            System.out.println("Interacton's ID                  : " + listOfInter.next().substring(6,9));
            System.out.println("Interacton's Date of Interaction : " + listOfInter.next());
            System.out.println("Interacton's associated Lead's ID: " + listOfInter.next());
            System.out.println("Interacton's Method              : " + listOfInter.next());
            System.out.println("Interacton's Potential           : " + listOfInter.next());
            System.out.println();
        }
        listOfInter.close();

        System.out.println();
    }

    public void displayOne () throws FileNotFoundException {

        Scanner listOfInter = new Scanner(new File("interactions.csv"));
        listOfInter.useDelimiter("[,\n]");
        String id;
        InteractionIdCheck idCheck = new InteractionIdCheck();
        int interIdToDisplay = idCheck.interIdCheck();

        while (listOfInter.hasNext()) {

            id = listOfInter.next();
            if ((id.equals("inter_" + String.format("%03d", interIdToDisplay)))) {
                System.out.println("Interacton's ID                  : " + id.substring(6,9));
                System.out.println("Interacton's Date of Interaction : " + listOfInter.next());
                System.out.println("Interacton's associated Lead's ID: " + listOfInter.next());
                System.out.println("Interacton's Method              : " + listOfInter.next());
                System.out.println("Interacton's Potential           : " + listOfInter.next());
                System.out.println();
                break;
            } else {
                listOfInter.next();
                listOfInter.next();
                listOfInter.next();
                listOfInter.next();
            }
        }
        listOfInter.close();
    }
}
