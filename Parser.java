import java.util.Scanner;

public class Parser {

    private static Scanner scan;
    private static String firstWord;
    private static String secondWord = null;
    public static void main(String[] args) {

    }

    public Parser() {

    }

    public static boolean parse(String input) {
        if (input.indexOf(" ") != -1) {
            firstWord = input.substring(0, input.indexOf(" "));
            secondWord = input.substring(input.indexOf(" "));
        }
        //scan = new Scanner();
        //Class.forName(Main.player.getCurrentRoom())
        if (synonymCheck(firstWord, Grab.txt)) {
            Main.player.addItem(secondWord);
            Main.Class.forName(Main.player.getCurrentRoom()).removeItem(secondWord);
        }
        return true;
    }

    public static boolean synonymCheck(String word, File file) {
        scan = new Scanner(file);
        //firstWord = scan.nextLine();
        while(scan.hasNextLine()) {
            if (word == scan.nextLine()) {
                return true;
            }   
        }
        return false;
    }

}