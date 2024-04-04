package at.fhv.lab1.commandclient.database;


import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;
import java.util.ArrayList;

public class RoomDB {

    private ArrayList<Room> rooms;

    public RoomDB() {
        rooms = new ArrayList<>();
        rooms.add(new Room(1, false, 0, 2));
        rooms.add(new Room(2, true, 0, 4));
        rooms.add(new Room(3, false, 0, 3));
        rooms.add(new Room(11, true, 1, 1));
        rooms.add(new Room(12, false, 1, 1));
        rooms.add(new Room(13, false, 1, 6));
        rooms.add(new Room(21, false, 2, 2));
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

}
