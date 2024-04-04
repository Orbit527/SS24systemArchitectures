package at.fhv.lab1.commandclient.domain;

public class BookingRest {

    private String customer;
    private long timestampStart;
    private long timestampEnd;
    private long roomID;

    public BookingRest() {
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    @Override
    public String toString() {
        return "BookingRest{" +
                "customer='" + customer + '\'' +
                ", timestampStart=" + timestampStart +
                ", timestampEnd=" + timestampEnd +
                ", roomID=" + roomID +
                '}';
    }
}
