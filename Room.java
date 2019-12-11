import java.util.*;

public class Room {

    private static ArrayList<String> items = new ArrayList<String>();
    private boolean isDark;
    private String name;
    private String description;

    private static HashMap<String, Room> exits = new HashMap<>();

    public static void main(String[] args) {
        exits = new ArrayList<String>();
    }

    public Room(String name, boolean isDark) {
        this.name = name;
        this.isDark = isDark;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void setDark() {
        isDark = true;
    }

    public void setLight() {
        isDark = false;
    }

    public boolean isDark() {
        return isDark;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void getDescription() {
        System.out.println(name);
        System.out.println(description);
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }

    public void setExit(String exit, Room destination) {
        exits.put(exit, destination);
    }

    public String move(String direction) {
        if (exits.get(direction.toLowerCase()) != null) {
            //Main.player.setCurrentRoom(exits.get(direction.toLowerCase()));
        } 
        return "You can't go that way";
    }

}