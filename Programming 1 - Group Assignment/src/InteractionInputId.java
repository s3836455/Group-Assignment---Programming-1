import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InteractionInputId {

    public int interactionInputId() {

        int id;
        String lastLine = "";

        try {
            String sCurrentLine;

            BufferedReader br = new BufferedReader(new FileReader("interactions.csv"));

            while ((sCurrentLine = br.readLine()) != null) {
                lastLine = sCurrentLine;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (lastLine.equals("")) {
            id = 1;
        } else {
            id = Integer.parseInt(lastLine.substring(6,9)) + 1;
        }

        System.out.println("Interaction's ID: inter_" + String.format("%03d", id));

        return id;
    }
}
