package at.fhv.lab1.commandclient.domain;

public class BookingRest {

    private int customerID;
    private int roomID;
    private String bookedStart;
    private String bookedEnd;

    public BookingRest() {
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getBookedStart() {
        return bookedStart;
    }

    public void setBookedStart(String bookedStart) {
        this.bookedStart = bookedStart;
    }

    public String getBookedEnd() {
        return bookedEnd;
    }

    public void setBookedEnd(String bookedEnd) {
        this.bookedEnd = bookedEnd;
    }

    @Override
    public String toString() {
        return "BookingRest{" +
                "customerID=" + customerID +
                ", roomID=" + roomID +
                ", bookedStart='" + bookedStart + '\'' +
                ", bookedEnd='" + bookedEnd + '\'' +
                '}';
    }
}
