package at.fhv.lab1.commandclient.database;


import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;
import java.util.ArrayList;

public class RoomDB {

    private static ArrayList<Room> rooms;

    public RoomDB() {
        rooms = new ArrayList<>();
    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    public static Room getRoomById(int id) {
        for(Room r : rooms) {
            if(r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public static void addRoom(Room room) {
        rooms.add(room);
    }

    public static void removeRoom(Room room) {
        rooms.remove(room);
    }

}
