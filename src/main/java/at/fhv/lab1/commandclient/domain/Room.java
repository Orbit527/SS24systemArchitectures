package at.fhv.lab1.commandclient.domain;

public class Room {

    private static int idCounter;
    private final int id;
    private int roomNr;
    private boolean currentlyBooked;
    private int floor;
    private int capacity;

    public Room() {
        id = idCounter++;
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

    public boolean isCurrentlyBooked() {
        return currentlyBooked;
    }

    public void setCurrentlyBooked(boolean currentlyBooked) {
        this.currentlyBooked = currentlyBooked;
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
                ", currentlyBooked=" + currentlyBooked +
                ", floor=" + floor +
                ", capacity=" + capacity +
                '}';
    }
}
