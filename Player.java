import java.util.ArrayList;

public class Player {

    private static ArrayList<String> items = new ArrayList<String>();
    private String name;
    private boolean alive;
    private Room currentRoom;
    private boolean proteinPowder;
    private boolean strong;
    private boolean warm;
    private boolean mrO;
    private boolean david;
    private int ergCount = 0;
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

    public void ergIncrement() {
        ergCount++;
    }

    public int getErg() {
        return ergCount;
    }

    public void setProtein(boolean protein) {
        proteinPowder = protein;
    }

    public boolean getProtein() {
        return proteinPowder;
    }

    public void setStrong(boolean strong) {
        this.strong = strong;
    }

    public boolean getStrong() {
        return strong;
    }

    public void setWarm(boolean warm) {
        this.warm = warm;
    }

    public boolean isWarm() {
        return warm;
    }

    public void setMrO(boolean mrO) {
        this.mrO = mrO;
    }

    public boolean getMrO() {
        return mrO;
    }

    public void setDavid(boolean david) {
        this.david = david;
    }

    public boolean getDavid() {
        return david;
    }
}