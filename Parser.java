import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Parser {

    private static Scanner scan;
    private static String firstWord = null;
    private static String secondWord = null;
    public static void main(String[] args) {

    }

    public Parser() {

    }

    public void parse(String input) {
        if (input.indexOf(" ") != -1) {
            firstWord = input.substring(0, input.indexOf(" ")).trim();
            secondWord = input.substring(input.indexOf(" ")).trim();
        } else if (input.trim().equals("inventory".substring(0, input.length()))) {
            Main.player.inventory();
        } else if (input.trim().equals("look".substring(0, input.length()))) {
            Main.player.getCurrentRoom().getDescription();
        } else if (Main.player.getCurrentRoom().getExit(input.trim())) {
            Main.player.getCurrentRoom().move(input.trim());
            Main.player.getCurrentRoom().getDescription();
        }

        if (synonymCheck(firstWord, "Grab.txt")) {
            if (Main.player.getCurrentRoom().hasItem(secondWord)) {
                Main.player.addItem(secondWord);
                Main.player.getCurrentRoom().removeItem(secondWord);
                reset();
            } else {
                System.out.println("That item doesn't exist here.");
                reset();
            }
        }
        
        if (synonymCheck(firstWord, "Drop.txt")) {
            if (Main.player.hasItem(secondWord)) {
                Main.player.removeItem(secondWord);
                Main.player.getCurrentRoom().addItem(secondWord);
                reset();
            } else {
                System.out.println("You don't have that item to drop.");
                reset();
            }
        }

    }

    public static boolean synonymCheck(String word, String list) {
        if (!(word == null)) {
            File file;
            try {
                file = new File("Words/" + list);
                scan = new Scanner(file);
                while(scan.hasNextLine()) {
                    if (word.equals(scan.nextLine())) {
                        return true;
                    }   
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void reset() {
        firstWord = null;
        secondWord = null;
    }

}