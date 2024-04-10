package at.fhv.lab1.commandclient.commands;

public class CreateRoomCommand {

    private int roomNr;
    private int floor;
    private int capacity;

    public CreateRoomCommand() {

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
        return "CreateRoomCommand{" +
                "roomNr=" + roomNr +
                ", floor=" + floor +
                ", capacity=" + capacity +
                '}';
    }
}
