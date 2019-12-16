import java.util.*;

public class Room {

    private ArrayList<String> items = new ArrayList<String>();
    private String name;
    private String description;
    private boolean locked;

    private HashMap<String, Room> exits = new HashMap<>();

    public static void main(String[] args) {
    }

    public Room(String name, boolean locked) {
        this.name = name;
        this.locked = locked;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void getDescription() {
        System.out.println(name);
        System.out.println(description);
        if (items != null) {
            for (int i = 0; i < items.size(); i++) {
                System.out.println(items.get(i));
            }
        }
    }

    public void setExit(String exit, Room destination) {
        exits.put(exit, destination);
    }

    public boolean getExit(String exit) {
        return exits.get(exit) != null;
    }

    public Room returnExit(String exit) {
        return exits.get(exit);
    }

    public boolean hasItem(String item) {
        return items.contains(item);
    }

    public void move(String direction) {
        Main.player.setCurrentRoom(exits.get(direction));
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }

}