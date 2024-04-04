package at.fhv.lab1.commandclient.domain;

public class Booking {

    private static int idCounter;
    private final int id;
    private Customer customer;
    private long timestampStart;
    private long timestampEnd;
    private Room room;

    public Booking() {
        id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customer=" + customer +
                ", timestampStart=" + timestampStart +
                ", timestampEnd=" + timestampEnd +
                ", room=" + room +
                '}';
    }
}
