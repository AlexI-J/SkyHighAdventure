import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Parser {

    private static Scanner scan;
    private static String firstWord;
    private static String secondWord = null;
    public static void main(String[] args) {

    }

    public Parser() {

    }

    public void parse(String input) {
        if (input.indexOf(" ") != -1) {
            firstWord = input.substring(0, input.indexOf(" ")).trim();
            secondWord = input.substring(input.indexOf(" ")).trim();
        } else if (input.trim().toLowerCase().equals("inventory".substring(0, input.length()))) {
            Main.player.inventory();
            System.out.println("GOT THERE");
        }

        //Class.forName(Main.player.getCurrentRoom())
        if (synonymCheck(firstWord, "Grab.txt")) {
            System.out.println("Got to the check");
            System.out.println(secondWord);
            Main.player.addItem(secondWord);
            //.removeItem(secondWord);
        }
    }

    public static boolean synonymCheck(String word, String list) {
        File file;
        try {
             file = new File(list);
             scan = new Scanner(file);
             while(scan.hasNextLine()) {
                 if (word.equals(scan.nextLine())) {
                     return true;
                 }   
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}