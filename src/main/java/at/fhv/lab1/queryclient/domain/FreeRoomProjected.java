package at.fhv.lab1.queryclient.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class FreeRoomProjected {

    private int roomId;
    private int roomNr;
    private int floor;
    private int capacity;
    private ArrayList<Timeframe> timeframes;

    public FreeRoomProjected() {
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

    public Timeframe getTimeFrameByDate(LocalDate startDate, LocalDate endDate) {
        for (Timeframe timeframe : this.timeframes) {
            if (timeframe.getStartDate() == startDate && timeframe.getEndDate() == endDate) {
                return timeframe;
            }
        }
        return null;
    }

    public void setTimeframes(ArrayList<Timeframe> timeframes) {
        this.timeframes = timeframes;
    }

    public void addTimeFrame(Timeframe timeframe) {
        this.timeframes.add(timeframe);
    }

    public void removeTimeframe(Timeframe timeframe) {
        this.timeframes.remove(timeframe);
    }

    @Override
    public String toString() {
        return "{" +
                "\"roomId\":" + roomId +
                ", \"roomNr\":\"" + roomNr + "\"" +
                ", \"floor\":" + floor +
                ", \"capacity\":" + capacity +
                ", \"timeframes\":" + timeframes +
                "}";
    }
}
