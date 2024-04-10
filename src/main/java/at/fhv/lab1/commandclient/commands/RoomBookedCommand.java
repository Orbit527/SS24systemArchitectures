package at.fhv.lab1.commandclient.commands;

import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;

import java.time.LocalDate;

public class RoomBookedCommand {

    private Booking booking;
    private Customer customer;
    private Room room;
    private LocalDate bookedStart;
    private LocalDate bookedEnd;


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
        return "RoomBookedCommand{" +
                "booking=" + booking +
                ", customer=" + customer +
                ", room=" + room +
                ", bookedStart=" + bookedStart +
                ", bookedEnd=" + bookedEnd +
                '}';
    }
}
