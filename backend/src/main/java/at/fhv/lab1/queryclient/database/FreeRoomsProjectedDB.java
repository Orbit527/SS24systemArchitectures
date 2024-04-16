package at.fhv.lab1.queryclient.database;

import at.fhv.lab1.queryclient.domain.FreeRoomProjected;

import java.util.ArrayList;
import java.util.Objects;

public class FreeRoomsProjectedDB {

    private static ArrayList<FreeRoomProjected> freeRooms;

    public FreeRoomsProjectedDB() {
        freeRooms = new ArrayList<>();
    }

    public static ArrayList<FreeRoomProjected> getFreeRooms() {
        return freeRooms;
    }

    public static FreeRoomProjected getRoomById(int id) {
        for(FreeRoomProjected r: freeRooms) {
            if(Objects.equals(r.getRoomId(), id)) {
                return r;
            }
        }
        return null;
    }

    public static void addFreeRoom(FreeRoomProjected room) {
        freeRooms.add(room);
    }

    public static void removeFreeRoom(FreeRoomProjected room) {
        freeRooms.remove(room);
    }

    public static void removeFreeRooms() {
        freeRooms.clear();
    }
}
