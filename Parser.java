import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Parser {

    private static Scanner scan;
    private static String firstWord = null;
    private static String secondWord = null;
    private boolean snakes = true;
    public static void main(String[] args) {

    }

    public Parser() {

    }

    private Room getRoom() {
        return Main.player.getCurrentRoom();
    }

    public void parse(String input) {
        if (input.indexOf(" ") != -1) {
            firstWord = input.substring(0, input.indexOf(" ")).trim();
            secondWord = input.substring(input.indexOf(" ")).trim();
        } else if (input.trim().equals("i")) {
            Main.player.inventory();
        } else if (input.trim().equals("l")) {
            getRoom().getDescription();
        } else if (getRoom().getExit(input.trim())) {
            if (!getRoom().returnExit(input.trim()).isLocked()) {
                getRoom().move(input.trim());
                getRoom().getDescription();
            } else {
                System.out.println("You can't go this way.");
            }
        }

        if (synonymCheck(firstWord, "Flashlight.txt") && secondWord.equals("flashlight")) {
            if (Main.player.hasItem("flashlight") && Main.insideEntrance.isLocked()) {
                Main.insideEntrance.setLocked(false);
                System.out.println("The flashlight turned on.");
                Main.entrance.setDescription("The front of Skyline looms above you in the north, and you can finally see it and enter. You know something is wrong but you don't know what. The student drop off is to the east and you can see the athletic entrance far in the west.");
            }
        }

        if (getRoom().equals(Main.insideEntrance)) {
            if (synonymCheck(firstWord, "Plaque.txt") && secondWord.equals("plaque")) {
                System.out.println("The plaque shifted away to reveal a pair of running shoes");
                getRoom().addItem("running shoes");
            }
        }

        if (getRoom().equals(Main.westernHallway)) {
            if (synonymCheck(firstWord, "Trophy.txt") && (secondWord.equals("glass") || secondWord.equals("trophy case") || secondWord.equals("case"))) {
                if (Main.player.hasItem("weight")) {
                    System.out.println("The glass shattered and fell to the ground, revealing the trophy from inside.");
                    getRoom().addItem("trophy");
                }
            } else if (synonymCheck(firstWord, "Weight.txt") && secondWord.equals("weight")) {
                if (Main.player.hasItem("weight")) {
                    System.out.println("The glass shattered and fell to the ground, revealing the trophy from inside.");
                    getRoom().addItem("trophy");
                }
            }
        }

        if (synonymCheck(firstWord, "Protein.txt") && secondWord.equals("protein powder")) {
            if (Main.player.hasItem("protein powder")) {
                Main.player.setProtein(true);
                Main.player.removeItem("protein powder");
                System.out.println("You ate the protein powder. You feel like working out and getting gains.");
            }
        }

        if (getRoom().equals(Main.crewHall)) {
            if (input.equals("erg") || input.equals("row") || (synonymCheck(firstWord, "Erg.txt") && secondWord.equals("erg"))) {
                if (Main.player.getErg() == 9) {
                    System.out.println("From the excessive rowing, you became ultra-strong! Your protein powder wore off.");
                    Main.a3Hall.setDescription("A computer cart is stranded in the middle of the hall, needing to be put away. With your workout, you are now strong enough to move the cart. The staff room leads to the north.");
                    Main.player.setProtein(false);
                    Main.player.setStrong(true);
                    Main.a3Hall.addItem("cart");
                } else if (Main.player.getProtein()) {
                    System.out.println("This is tough work, but you can feel yourself getting stronger.");
                    Main.player.ergIncrement();
                }
            }
        }

        if (getRoom().hasItem("cart")) {
            if (Main.player.getStrong()) {
                if (synonymCheck(firstWord, "Cart.txt") && (secondWord.equals("cart") || secondWord.equals("computer cart"))) {
                    Main.player.addItem("cart");
                    getRoom().removeItem("cart");
                    System.out.println("You got the cart.");
                }
            }
        }

        if (getRoom().equals(Main.administration)) {
            Main.player.kill();
        }

        if (synonymCheck(firstWord, "Coat.txt")) {
            if (Main.player.hasItem("coat")) {
                Main.player.setWarm(true);
                System.out.println("You put on the coat. You feel warm inside now.");
                Main.player.removeItem("coat");
            }
        }

        if (getRoom().equals(Main.oClassroom)) {
            if (synonymCheck(firstWord, "MrO.txt")) {
                if (Main.player.hasItem("trophy") && !Main.player.getMrO()) {
                    System.out.println("You present Mr.O with the trophy. 'Thanks" + Main.name + "! Here, why don't you have my staff key as thanks.");
                    Main.player.addItem("staff key");
                    Main.player.removeItem("trophy");
                    Main.player.setMrO(true);
                    getRoom().setDescription("Mr.O is looking happily at his trophy.");
                }
            }
        }

        if (getRoom().equals(Main.upBathroom)) {
            if ((synonymCheck(firstWord, "Juul.txt") && secondWord.equals("juul")) || input.equals("juul")) {
                if (Main.player.hasItem("juul")) {
                    System.out.println("Well... you did it. You discovered the secret ending. The school is still full of mystery but you are gone. You've ascended. I guess you'll never know what super secret hidden ending I had planned, but that's okay, because you're special and found this little joke. Thanks for playing.");
                    Main.player.kill();
                }
            }
        }

        if (getRoom().equals(Main.iCommons)) {
            if (synonymCheck(firstWord, "Music.txt") && secondWord.equals("viola")) {
                if (Main.player.hasItem("viola") && !Main.player.getDavid()) {
                    System.out.println("Performing for David, he quickly finishes his work and walks over to you. 'Thanks for the great performance " + Main.name + "! Here, I had this flute, but I don't need it so I'll give it to you.'");
                    Main.player.addItem("flute");
                    Main.player.setDavid(true);
                }
            }
        }

        if (getRoom().equals(Main.a4Hall)) {
            if (synonymCheck(firstWord, "Music.txt") && (secondWord.equals("flute") || secondWord.equals("snake") || secondWord.equals("snakes"))) {
                if (Main.player.hasItem("flute") && (snakes == true)) {
                    Main.a4Hall.setDescription("The hall is voided of all snakes. All that is still here is a door to the north, into a classroom.");
                    Main.burgirenoRoom.setLocked(false);
                    System.out.println("Your beautiful flute playing charmed all these pythons into leaving you alone, opening up the route to the classroom.");
                    snakes = false;
                }
            }
        }

        if (getRoom().equals(Main.burgirenoRoom)) {
            if (synonymCheck(firstWord, "Coffee.txt") && secondWord.equals("coffee")) {
                if (Main.player.hasItem("coffee")) {
                    System.out.println("The coffee seeped into every one of your veins and you know what to do. Using the power of semicolons, parentheses, and curly braces, you summon the power of java and object oriented programming to vaporize this man of python. When all finishes, the room goes quiet. It is finally over and you can leave. \n \n Congratulations on beating this convoluted mess of a game! I hope you enjoyed.");
                }
            }
        }

        if (synonymCheck(firstWord, "Grab.txt")) {
            if (getRoom().hasItem(secondWord)) {
                Main.player.addItem(secondWord);
                getRoom().removeItem(secondWord);
                reset();
            } else {
                System.out.println("That item doesn't exist here.");
                reset();
            }
        }
        
        if (synonymCheck(firstWord, "Drop.txt")) {
            if (Main.player.hasItem(secondWord)) {
                Main.player.removeItem(secondWord);
                getRoom().addItem(secondWord);
                reset();
            } else {
                System.out.println("You don't have that item to drop.");
                reset();
            }
        }

    }

    public static boolean synonymCheck(String word, String list) {
        if (word != null) {
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