package at.fhv.lab1.eventbus.events;

import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;

public class RoomBookedEvent {
    private Booking booking;
    private Customer customer;
    private Room room;
    private long timestampStart;
    private long timestampEnd;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    @Override
    public String toString() {
        return "RoomBookedEvent{" +
                "booking=" + booking +
                ", customer=" + customer +
                ", room=" + room +
                ", timestampStart=" + timestampStart +
                ", timestampEnd=" + timestampEnd +
                '}';
    }
}
