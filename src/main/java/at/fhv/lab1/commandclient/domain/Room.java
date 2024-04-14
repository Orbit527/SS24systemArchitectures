package at.fhv.lab1.commandclient.domain;

public class Room {

    private static int idCounter;
    private final int id;
    private int roomNr;
    private int floor;
    private int capacity;

    public Room() {
        this.id = idCounter++;
    }

    public Room(int roomNr, int floor, int capacity) {
        this.id = idCounter++;
        this.roomNr = roomNr;
        this.floor = floor;
        this.capacity = capacity;
    }

    public Room(int id, int roomNr, int floor, int capacity) {
        this.id = id;
        this.roomNr = roomNr;
        this.floor = floor;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public int getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNr=" + roomNr +
                ", floor=" + floor +
                ", capacity=" + capacity +
                '}';
    }
}
