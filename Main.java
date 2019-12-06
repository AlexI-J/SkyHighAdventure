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

        while(player.isAlive()) {
            test.getDescription();
            command = inp.nextLine();
            Parser.parse(command);
        }
    }

    public static void reset() {
        player.revive();
        player.setCurrentRoom("test");
        test.addItem("1");
        test.addItem("2");
        test.addItem("3");
        test.setExit("north", "test2");
        test.setDescription("this is a test");
        test.setExit("east", "test2");
    }
    
}