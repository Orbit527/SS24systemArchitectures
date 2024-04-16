package at.fhv.lab1.queryclient.domain;

import java.time.LocalDate;

public class BookingProjected {

    private int bookingId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String customerFirstname;
    private String customerSurname;
    private int roomId;
    private int roomNr;
    private int capacity;
    private int floor;


    public BookingProjected() {

    }
    public BookingProjected(int bookingId, LocalDate startDate, LocalDate endDate, String customerName, String customerSurname, int roomId, int roomNr, int capacity, int floor) {
        this.bookingId = bookingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerFirstname = customerName;
        this.customerSurname = customerSurname;
        this.roomId = roomId;
        this.roomNr = roomNr;
        this.capacity = capacity;
        this.floor = floor;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }


    @Override
    public String toString() {
        return "{" +
                "\"bookingId\":" + bookingId +
                ", \"startDate\":\"" + startDate + "\"" +
                ", \"endDate\":\"" + endDate + "\"" +
                ", \"customerFirstname\":\"" + customerFirstname + "\"" +
                ", \"customerSurname\":\"" + customerSurname + "\"" +
                ", \"roomId\":" + roomId +
                ", \"roomNr\":" + roomNr +
                ", \"capacity\":" + capacity +
                ", \"floor\":" + floor +
                "}";
    }
}
