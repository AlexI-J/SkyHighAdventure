import java.util.ArrayList;

public class Player {

    private static ArrayList<String> items = new ArrayList<String>();
    private String name;
    private boolean alive;
    //private String currentRoom;
    private Room currentRoom;
    public static void main(String[] args) {

    }

    public Player(String name) {
        this.name = name;

    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public boolean isAlive() {
        return alive;
    }

    public void kill() {
        alive = false;
    }

    public void revive() {
        alive = true;
    }

    public void inventory() {
        for (String i : items) {
            System.out.println(items);
        }
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public String getCurrentRoom() {
        return currentRoom;
    }

}