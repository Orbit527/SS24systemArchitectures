package at.fhv.lab1.commandclient.domain;

public class BookingRest {

    private int customerId;
    private long timestampStart;
    private long timestampEnd;
    private int roomID;

    public BookingRest() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(long timestampStart) {
        this.timestampStart = timestampStart;
    }

    public long getTimestampEnd() {
        return timestampEnd;
    }

    public void setTimestampEnd(long timestampEnd) {
        this.timestampEnd = timestampEnd;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    @Override
    public String toString() {
        return "BookingRest{" +
                "customerId=" + customerId +
                ", timestampStart=" + timestampStart +
                ", timestampEnd=" + timestampEnd +
                ", roomID=" + roomID +
                '}';
    }
}
