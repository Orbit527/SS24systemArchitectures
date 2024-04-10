package at.fhv.lab1.commandclient.domain;

import java.time.LocalDate;

public class Booking {

    private static int idCounter;
    private final int id;
    private Customer customer;
    private Room room;
    private LocalDate bookedStart;
    private LocalDate bookedEnd;


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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getBookedStart() {
        return bookedStart;
    }

    public void setBookedStart(LocalDate bookedStart) {
        this.bookedStart = bookedStart;
    }

    public LocalDate getBookedEnd() {
        return bookedEnd;
    }

    public void setBookedEnd(LocalDate bookedEnd) {
        this.bookedEnd = bookedEnd;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customer=" + customer +
                ", room=" + room +
                ", bookedStart=" + bookedStart +
                ", bookedEnd=" + bookedEnd +
                '}';
    }
}
