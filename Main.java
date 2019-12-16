import java.util.Scanner;

public class Main {

    static Scanner inp;

    static Parser parser;
    static Player player;

    static String name;
    static String command;

    static Room test;
    static Room test2;

    //1 + 2 floor rooms
    static Room entrance;
    static Room dropOff;
    static Room athleticEntrance;
    static Room athleticHallway;
    static Room weightRoom;
    static Room insideEntrance;
    static Room westernHallway;
    static Room easternHallway;
    static Room commons;
    static Room administration;
    static Room lowBathroom;
    static Room crewHall;
    static Room musicRooms;
    static Room choirRoom;
    static Room orchestraRoom;
    static Room bandRoom;

    //3 + 4 floor rooms
    static Room b3Hall;
    static Room a3Hall;
    static Room c3Hall;
    static Room staffRoom;
    static Room upBathroom;
    static Room iCommons;
    static Room oClassroom;
    static Room b4Hall;
    static Room a4Hall;
    static Room burgirenoRoom;
    public static void main(String[] args) {
        parser = new Parser();

        entrance = new Room("Student Entrance", false);
        dropOff = new Room("Student Drop Off", false);
        athleticEntrance = new Room("Athletic Entrance", false);
        athleticHallway = new Room("Athletic Hall", true);
        weightRoom = new Room("Weight Room", false);
        insideEntrance = new Room("Inside the Entrance", true);
        westernHallway = new Room("Western Hallway", false);
        easternHallway = new Room("Eastern Hallway", false);
        commons = new Room("The Commons", false);
        administration = new Room("Administrative Offices", false);
        lowBathroom = new Room("Bathroom", false);
        crewHall = new Room("The Crew Hall", false);
        musicRooms = new Room("The Music Hallway", false);
        choirRoom = new Room("The Choir Room", false);
        orchestraRoom = new Room("The Orchestra Room", true);
        bandRoom = new Room("The Band Room", false);

        b3Hall = new Room("Third Floor B Hallway", false);
        a3Hall = new Room("Third Floor A Hallway", false);
        c3Hall = new Room("Third Floor C Hallway", false);
        staffRoom = new Room("The Staff Room", true);
        upBathroom = new Room("Bathroom", false);
        iCommons = new Room("The iCommons", true);
        oClassroom = new Room("Mr. O's Classroom", false);
        b4Hall = new Room("Fourth Floor B Hallway", false);
        a4Hall = new Room("Fourth Floor A Hallway", false);
        burgirenoRoom = new Room("Mr. Burgireno's Room", true);

        test = new Room("test", false);
        test2 = new Room("test2", false);
        inp = new Scanner(System.in);

        System.out.println("What is your name?");
        name = inp.nextLine();
        player = new Player(name);
        reset();
        player.getCurrentRoom().getDescription();

        while(player.isAlive()) {
            check();
            command = inp.nextLine().toLowerCase();
            parser.parse(command);
        }
    }

    public static void reset() { 
        player.revive();
        player.setCurrentRoom(entrance);
        
        player.setDavid(false);
        player.setMrO(false);
        player.setStrong(false);
        player.setProtein(false);
        player.setWarm(false);

        entrance.setDescription("The front of Skyline looms above you in the north, but it's too dark to enter. You know something is wrong but you don't know what. The student drop off is to the east and you can see the athletic entrance far in the west.");
        dropOff.setDescription("You can imagine the hundreds of cars that pass through here everyday. A surprising number of dead rats lie about among the bushes, and a flashlight is hidden among them.");
        athleticEntrance.setDescription("Three locked doors appear in front of you to the north. You can glimpse slightly through the window, bringing into view bits of the athletic hallway. If only you had some athletic equipment...");
        athleticHallway.setDescription("The smell of musty sweat looms around the recently mopped hallway. Pictures of past athletes line the walls, with bags of protein powder just happening to lie about, nearly blocking the entrance of the weight room to the west. The doors usually leading to the other hall appear to have been locked.");
        weightRoom.setDescription("Weights lie around all over the floor. You feel powerful just being here. An exit to the east leads back to the hall.");
        insideEntrance.setDescription("You reach the inside of the entrance, to the south leads the outside. A historic plaque decorates the wall, commemorating the founding of Skyline High School. To the northwest is the western hall that leads to the commons, and directly opposite to it in the northeast is the eastern hall. You can see in the east another hall leading away.");
        westernHallway.setDescription("The hall is adorned with hard and locked glass cases full of club and sports related goodies, you notice a good number of trophies celebrating a variety of accomplishments. Further to the north you can see The Commons, and to the south is the entrance.");
        easternHallway.setDescription("A beautiful hall filled with cabinets of decoration, nothing quite like the western hall though.... The commons appear in the north and the entrance is back towards the south.");
        musicRooms.setDescription("You come to a cross-section of the arts. To north is the choir room, the orchestra room is locked and to the east, and the band room to the south. It appears that the orchestra room is currently locked. Back to the west is the entrance.");
        choirRoom.setDescription("Nothing interesting happens here, just some singing.");
        orchestraRoom.setDescription("The orchestra room walls are lined with pictures of years past and present. Chairs are lined up in the middle of the room, with an open case containing a viola sitting on one.");
        bandRoom.setDescription("The ceiling towers over you, and lockers of tuxedos and dresses fill the air with professionalism. Upon the conductor's podium lies a key. I wonder where it could be used?");
        commons.setDescription("The large hub is eerily empty. Stairs to the north invite you to adventure futher into Skyline. The administrative rooms run off to the west and an empty hallway to the northeast. Bathrooms sit in the east and a western and eastern hallways are to the southwest and southeast respectively. A nice, warm coat is left abandoned on a table.");
        lowBathroom.setDescription("It sure is a bathroom. A Juul is left on the sink. Exit to the west");
        administration.setDescription("What a terrible place to be. It happens that you were keeping your hood up, so you died in the sheer rebellion of your actions. Additionally, you lose your benefits. Sorry, not sorry.");
        crewHall.setDescription("The crew hall is filled with ergs scattered on the ground. Maybe you could build some muscle if you used it. The commons are back to the west.");

        b3Hall.setDescription("The iCommons are to the north and appear to currently be locked. Maybe you could get in if you a reason to go there. It's surrounded by bathrooms to your northwest and northeast. The A hallway is to the west and the C hallway is to the east. Stairs lead back down to the commons and up to the fourth floor.");
        c3Hall.setDescription("All the rooms are locked except for one to the north.");
        oClassroom.setDescription("Mr. O is inside the room. 'Oh you're here,' he says, 'Did you finally bring me my trophy for winning the fantasy league?'");
        upBathroom.setDescription("It's just like the one downstairs. Exit back to the south.");
        a3Hall.setDescription("A computer cart is stranded in the middle of the hall, needing to be put away. It seems to heavy for you to move it now though. The staff room leads to the north and is currently locked.");
        iCommons.setDescription("David is sitting at a table, working on his online class. I bet he could focus better with some music to listen to.");
        staffRoom.setDescription("The room is empty, except for the smell of fresh coffee, a hot cup o' joe, a steaming mug of java, eminating from a cup in the corner.");

        b4Hall.setDescription("It's freezing up here, dangerously cold, if only the school's heating system worked. To the west you see the A hallway, filled with snakes, specifically pythons. Stairs lead back down to the 3rd floor.");
        a4Hall.setDescription("You're surrounded by snakes, you need to act quick. A room seems to be open past them to the north, if only you could get through.");
        burgirenoRoom.setDescription("The source of the snakes that you've seen in the school, and the source of your problems, Mr. Burgireno stands menacingly behind his desk. 'Finish me if you can, " + name + "!' he shouts at you. You must find a way to defeat him.");

        dropOff.addItem("flashlight");
        athleticHallway.addItem("protein powder");
        weightRoom.addItem("weight");
        commons.addItem("coat");
        lowBathroom.addItem("juul");
        orchestraRoom.addItem("viola");
        bandRoom.addItem("music key");
        staffRoom.addItem("coffee");

        entrance.setExit("east", dropOff);
        entrance.setExit("west", athleticEntrance);
        entrance.setExit("north", insideEntrance);
        dropOff.setExit("west", entrance);
        athleticEntrance.setExit("east", entrance);
        athleticEntrance.setExit("north", athleticHallway);
        athleticHallway.setExit("west", weightRoom);
        athleticHallway.setExit("south", athleticEntrance);
        weightRoom.setExit("east", athleticHallway);
        insideEntrance.setExit("east", musicRooms);
        insideEntrance.setExit("south", entrance);
        insideEntrance.setExit("northeast", easternHallway);
        insideEntrance.setExit("northwest", westernHallway);
        westernHallway.setExit("south", insideEntrance);
        westernHallway.setExit("north", commons);
        easternHallway.setExit("south", insideEntrance);
        easternHallway.setExit("north", commons);
        commons.setExit("up", b3Hall);
        commons.setExit("northeast", crewHall);
        commons.setExit("east", lowBathroom);
        commons.setExit("southeast", easternHallway);
        commons.setExit("southwest", westernHallway);
        commons.setExit("west", administration);
        musicRooms.setExit("west", insideEntrance);
        musicRooms.setExit("north", choirRoom);
        musicRooms.setExit("east", orchestraRoom);
        musicRooms.setExit("south", bandRoom);
        choirRoom.setExit("south", musicRooms);
        orchestraRoom.setExit("west", musicRooms);
        bandRoom.setExit("north", musicRooms);
        lowBathroom.setExit("west", commons);
        crewHall.setExit("west", commons);

        b3Hall.setExit("up", b4Hall);
        b3Hall.setExit("down", commons);
        b3Hall.setExit("north", iCommons);
        b3Hall.setExit("east", c3Hall);
        b3Hall.setExit("northeast", upBathroom);
        b3Hall.setExit("northwest", upBathroom);
        b3Hall.setExit("west", a3Hall);
        upBathroom.setExit("south", b3Hall);
        iCommons.setExit("south", b3Hall);
        c3Hall.setExit("west", b3Hall);
        c3Hall.setExit("north", oClassroom);
        oClassroom.setExit("south", c3Hall);
        a3Hall.setExit("east", b3Hall);
        a3Hall.setExit("north", staffRoom);
        staffRoom.setExit("south", a3Hall);

        b4Hall.setExit("down", b3Hall);
        b4Hall.setExit("west", a4Hall);
        a4Hall.setExit("east", b4Hall);
        a4Hall.setExit("north", burgirenoRoom);
        burgirenoRoom.setExit("south", a4Hall);
    }

    private static void check() {
        if (player.hasItem("running shoes")) {
            athleticHallway.setLocked(false);
            athleticEntrance.setDescription("The previously locked doors are now unlocked, probably because you look a little more athletic with your shoes now. The entrance is back to the east and the doors are to the north.");
        } else {
            athleticHallway.setLocked(true);
            athleticEntrance.setDescription("Three locked doors appear in front of you to the north. You can glimpse slightly through the window, bringing into view bits of the athletic hallway. If only you had some athletic equipment...");
        }

        if (player.hasItem("music key")) {
            orchestraRoom.setLocked(false);
            musicRooms.setDescription("You come to a cross-section of the arts. To north is the choir room, the orchestra room is to the east, and the band room to the south. The orchestra room is no longer locked. Back to the west is the entrance.");
        } else {
            orchestraRoom.setLocked(true);
            musicRooms.setDescription("You come to a cross-section of the arts. To north is the choir room, the orchestra room is to the east, and the band room to the south. It appears that the orchestra room is currently locked. Back to the west is the entrance.");
        }

        if (player.hasItem("cart")) {
            iCommons.setLocked(false);
            b3Hall.setDescription("The iCommons are to the north, having just been mysteriously unlocked for you, and is surrounded by bathrooms to your northwest and northeast. The A hallway is to the west and the C hallway is to the east. Stairs lead back down to the commons and up to the fourth floor.");

        } else {
            iCommons.setLocked(true);
            b3Hall.setDescription("The iCommons are to the north and appear to currently be locked. Maybe you could get in if you a reason to go there. It's surrounded by bathrooms to your northwest and northeast. The A hallway is to the west and the C hallway is to the east. Stairs lead back down to the commons and up to the fourth floor.");

        }

        if (player.hasItem("staff key")) {
            staffRoom.setLocked(false);
            if (Main.player.hasItem("cart")) {
                a3Hall.setDescription("The staff room is off to the north.");
            } else {
                if (player.getStrong()) {
                    a3Hall.setDescription("A computer cart is stranded in the middle of the hall, needing to be put away. It doesn't seem to be as heavy as it was before. The staff room leads to the north and is no longer locked.");

                } else {
                    a3Hall.setDescription("A computer cart is stranded in the middle of the hall, needing to be put away. It seems to heavy for you to move it for now though. The staff room leads to the north and is no longer locked.");
                }
            }
        } else {
            staffRoom.setLocked(true);
            if (player.hasItem("cart")) {
                a3Hall.setDescription("The staff room is off the to the north, still locked.");
            } else {
                if (player.getStrong()) {
                    a3Hall.setDescription("A computer cart is stranded in the middle of the hall, needing to be put away. It doesn't seem to be as heavy as it was before. The staff room leads to the north and is currently locked.");
                } else {
                    a3Hall.setDescription("A computer cart is stranded in the middle of the hall, needing to be put away. It seems to heavy for you to move it for now though. The staff room leads to the north and is currently locked.");
                }
            }
        }

        if (!dropOff.hasItem("flashlight")) {
            dropOff.setDescription("You can imagine the hundreds of cars that pass through here everyday. A surprising number of dead rats lie about among the bushes.");
        } else {
            dropOff.setDescription("You can imagine the hundreds of cars that pass through here everyday. A surprising number of dead rats lie about among the bushes, and a flashlight is hidden among them.");
        }

        if (!commons.hasItem("coat")) {
            commons.setDescription("The large hub is eerily empty. Stairs to the north invite you to adventure futher into Skyline. The administrative rooms run off to the west and an empty hallway to the northeast. Bathrooms sit in the east and a western and eastern hallways are to the southwest and southeast respectively.");
        } else {
            commons.setDescription("The large hub is eerily empty. Stairs to the north invite you to adventure futher into Skyline. The administrative rooms run off to the west and an empty hallway to the northeast. Bathrooms sit in the east and a western and eastern hallways are to the southwest and southeast respectively. A nice, warm coat is left abandoned on a table.");
        }

        if (player.getCurrentRoom().equals(a4Hall) || player.getCurrentRoom().equals(b4Hall) || player.getCurrentRoom().equals(burgirenoRoom)) {
            double num = Math.random();
            if (!Main.player.isWarm()) {
                if (num < .33) {
                    Main.player.kill();
                    System.out.println("It was too cold for you and you died from it, might want to wear something warmer next time.");
                }
            }
        }
    }
    
}