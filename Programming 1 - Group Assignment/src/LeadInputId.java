import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeadInputId {

    public int leadInputId() {

        int id;
        String lastLine = "";

        try {
            String sCurrentLine;

            BufferedReader br = new BufferedReader(new FileReader("leads.csv"));

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
            id = Integer.parseInt(lastLine.substring(5,8)) + 1;
        }

        System.out.println("Lead's ID: lead_" + String.format("%03d", id));

        return id;
    }
}
