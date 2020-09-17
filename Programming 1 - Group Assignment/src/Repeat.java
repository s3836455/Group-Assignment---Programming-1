public class Repeat implements Repeatable {

    public char repeat () {

        char checkRepeat = 0;
        int checkQualify;

        do {
            checkQualify = 0;

            try {
                checkRepeat = Main.scanner.next().charAt(0);
                Main.scanner.nextLine();

                if (!(checkRepeat == 'Y') && !(checkRepeat =='N') && !(checkRepeat =='y') && !(checkRepeat =='n')) {
                    System.out.println("Please only enter character Y for Yes or character N for No!");
                    System.out.println("Please enter this information again.");
                    checkQualify = 1;
                }

            } catch (Exception e) {
                System.out.println("Please only enter character Y for Yes or character N for No!");
                System.out.println("Please enter this information again.");
                checkQualify = 1;
            }
        } while (checkQualify == 1);

        System.out.println();

        return checkRepeat;
    }
}
