package at.fhv.lab1.eventbus.events;

public class RoomBookedEvent {
    private long bookingID;
    private String customer;
    private long roomID;

    private long duration;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public long getBookingID() {
        return bookingID;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }

    @Override
    public String toString() {
        return "RoomBookedEvent{" +
                "bookingID=" + bookingID +
                ", customer='" + customer + '\'' +
                ", roomID=" + roomID +
                ", duration=" + duration +
                '}';
    }
}
