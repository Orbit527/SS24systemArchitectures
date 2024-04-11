package at.fhv.lab1.eventbus.events;

public class CreateRoomEvent {

    private int roomNr;
    private int floor;
    private int capacity;


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
        return "CreateRoomEvent{" +
                "roomNr=" + roomNr +
                ", floor=" + floor +
                ", capacity=" + capacity +
                '}';
    }
}
