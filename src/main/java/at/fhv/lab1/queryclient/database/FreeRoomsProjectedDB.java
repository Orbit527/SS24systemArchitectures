package at.fhv.lab1.queryclient.database;

import at.fhv.lab1.queryclient.domain.BookingsProjected;
import at.fhv.lab1.queryclient.domain.CustomersProjected;
import at.fhv.lab1.queryclient.domain.FreeRoomsProjected;

import java.util.ArrayList;
import java.util.Objects;

public class FreeRoomsProjectedDB {

    private static ArrayList<FreeRoomsProjected> freeRooms;

    public FreeRoomsProjectedDB() {
        freeRooms = new ArrayList<>();
    }

    public static ArrayList<FreeRoomsProjected> getFreeRooms() {
        return freeRooms;
    }

    public static FreeRoomsProjected getRoomById(int id) {
        for(FreeRoomsProjected r: freeRooms) {
            if(Objects.equals(r.getRoomId(), id)) {
                return r;
            }
        }
        return null;
    }

    public static void addFreeRoom(FreeRoomsProjected room) {
        freeRooms.add(room);
    }

    public static void removeFreeRoom(FreeRoomsProjected room) {
        freeRooms.remove(room);
    }


}
