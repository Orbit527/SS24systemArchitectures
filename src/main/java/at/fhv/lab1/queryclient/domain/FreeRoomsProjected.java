package at.fhv.lab1.queryclient.domain;

import java.util.ArrayList;

public class FreeRoomsProjected {

    private int roomId;
    private int roomNr;
    private int floor;
    private int capacity;
    private ArrayList<Timeframe> timeframes;

    public FreeRoomsProjected() {
        timeframes = new ArrayList<>();
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public ArrayList<Timeframe> getTimeframes() {
        return timeframes;
    }

    public void setTimeframes(ArrayList<Timeframe> timeframes) {
        this.timeframes = timeframes;
    }

    public void addTimeFrame(Timeframe timeframe) {
        this.timeframes.add(timeframe);
    }

    @Override
    public String toString() {
        return "FreeRoomsProjected{" +
                "roomId=" + roomId +
                ", roomNr=" + roomNr +
                ", floor=" + floor +
                ", capacity=" + capacity +
                ", timeframes=" + timeframes +
                '}';
    }
}
