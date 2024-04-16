package at.fhv.lab1.eventbus.events;

import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;

import java.time.LocalDate;

public class RoomBookedEvent {
    private Booking booking;
    private Customer customer;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    // Default constructor
    public RoomBookedEvent() {
    }

    public RoomBookedEvent(Booking booking, Customer customer, Room room, LocalDate startDate, LocalDate endDate) {
        this.booking = booking;
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

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
        return "{" +
                "\"event\":\"" + "RoomBookedEvent" + "\"," +
                "\"booking\":{" +
                "\"id\":" + booking.getId() + "," +
                "\"customer\":{" +
                "\"id\":" + customer.getId() + "," +
                "\"firstname\":\"" + customer.getFirstname() + "\"," +
                "\"surname\":\"" + customer.getSurname() + "\"," +
                "\"email\":\"" + customer.getEmail() + "\"," +
                "\"address\":\"" + customer.getAddress() + "\"," +
                "\"birthdate\":\"" + customer.getBirthdate() + "\"" +
                "}," +
                "\"room\":{" +
                "\"id\":" + room.getId() + "," +
                "\"roomNr\":" + room.getRoomNr() + "," +
                "\"floor\":" + room.getFloor() + "," +
                "\"capacity\":" + room.getCapacity() +
                "}," +
                "\"startDate\":\"" + startDate + "\"," +
                "\"endDate\":\"" + endDate + "\"" +
                "}}";
    }


}
