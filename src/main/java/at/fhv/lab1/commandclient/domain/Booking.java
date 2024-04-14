package at.fhv.lab1.commandclient.domain;

import java.time.LocalDate;

public class Booking {

    private static int idCounter;
    private final int id;
    private Customer customer;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;


    public Booking() {
        id = idCounter++;
    }

    public Booking(Customer customer, Room room, LocalDate startDate, LocalDate endDate) {
        this.id = idCounter++;
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking(int id, Customer customer, Room room, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
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

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customer=" + customer +
                ", room=" + room +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
