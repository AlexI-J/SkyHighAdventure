import java.util.ArrayList;

public class Player {

    private static ArrayList<String> items = new ArrayList<String>();
    private String name;
    private boolean alive;
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
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i) + ", ");
            System.out.println();
        }
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean hasItem(String item) {
        return items.contains(item);
    }

}