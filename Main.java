import java.util.Scanner;

public class Main {

    static Scanner inp;

    static Parser parser;
    static Player player;

    static String name;
    static String command;

    static Room test;
    static Room test2;
    public static void main(String[] args) {
        parser = new Parser();
        test = new Room("test", false);
        test2 = new Room("test2", true);
        inp = new Scanner(System.in);

        System.out.println("What is your name?");
        name = inp.nextLine();
        player = new Player(name);
        reset();
        player.getCurrentRoom().getDescription();

        while(player.isAlive()) {
            command = inp.nextLine().toLowerCase();
            parser.parse(command);
        }
    }

    public static void reset() {
        player.revive();
        player.setCurrentRoom(test);
        test.addItem("1");
        test.addItem("2");
        test.addItem("3");
        test.setExit("north", test2);
        test2.setExit("south", test);
        test.setDescription("this is a test");
        test2.setDescription("this is a test2");
    }
    
}