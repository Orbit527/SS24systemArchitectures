package at.fhv.lab1.commandclient.commandHandler;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commands.CancelBookingCommand;
import at.fhv.lab1.commandclient.commands.CreateCustomerCommand;
import at.fhv.lab1.commandclient.commands.CreateRoomCommand;
import at.fhv.lab1.commandclient.commands.RoomBookedCommand;
import at.fhv.lab1.commandclient.database.BookingDB;
import at.fhv.lab1.commandclient.database.CustomerDB;
import at.fhv.lab1.commandclient.database.RoomDB;
import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;
import at.fhv.lab1.commandclient.exceptions.CustomerNotCreatableException;
import at.fhv.lab1.commandclient.exceptions.NotBookableException;
import at.fhv.lab1.commandclient.exceptions.NotCancelableException;
import at.fhv.lab1.commandclient.exceptions.RoomNotAddableException;
import at.fhv.lab1.eventbus.events.CancelBookingEvent;
import at.fhv.lab1.eventbus.events.CreateCustomerEvent;
import at.fhv.lab1.eventbus.events.CreateRoomEvent;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class CommandHandler {

    private final EventPublisher eventPublisher;

    public CommandHandler() {
        eventPublisher = new EventPublisher();
    }

    public boolean handleRoomBookedCommand(RoomBookedCommand r) throws NotBookableException {

        //check for empty fields
        if (r.getBooking() == null || r.getEndDate() == null || r.getStartDate() == null) {
            throw new NotBookableException("Field cannot be empty!");
        }

        //check if Customer with that Id exists
        if (r.getCustomer() == null) {
            throw new NotBookableException("Customer with that ID does not exist!");
        }

        //check if Room with that Id exists
        if (r.getRoom() == null) {
            throw new NotBookableException("Room with that ID does not exist!");
        }

        //check that endDate is after startDate
        if (r.getEndDate().isBefore(r.getStartDate())) {
            throw new NotBookableException("Enddate is before Startdate!");
        }

        //check for overlapping date
        for (Booking b : BookingDB.getBookings()) {
            //Booking has to be on the same room
            if (b.getRoom().getId() == r.getRoom().getId()) {
                if(b.getStartDate().isBefore(r.getEndDate().plusDays(1)) && b.getEndDate().isAfter(r.getStartDate().minusDays(1))) {
                    throw new NotBookableException("There is a booking already in this timeframe!");
                }
            }
        }

        RoomBookedEvent roomBookedEvent = new RoomBookedEvent();
        roomBookedEvent.setCustomer(r.getCustomer());
        roomBookedEvent.setRoom(r.getRoom());
        roomBookedEvent.setBooking(r.getBooking());
        roomBookedEvent.setStartDate(r.getStartDate());
        roomBookedEvent.setEndDate(r.getEndDate());

        System.out.println("BookRoomEvent: " + eventPublisher.publishEvent(roomBookedEvent));

        return true;
    }

    public boolean handleCancelBookingCommand(CancelBookingCommand c) throws NotCancelableException {

        if (BookingDB.getBookingById(c.getId()) == null) {
            throw new NotCancelableException("Booking with that id does not exist!");
        }

        CancelBookingEvent cancelBookingEvent = new CancelBookingEvent();
        cancelBookingEvent.setId(c.getId());

        System.out.println("BookRoomEvent: " + eventPublisher.publishEvent(cancelBookingEvent));

        return true;
    }

    public boolean handleCreateCustomerCommand(CreateCustomerCommand c) throws CustomerNotCreatableException {

        //check for empty fields
        if (Objects.equals(c.getFirstname(), "") || Objects.equals(c.getSurname(), "") || Objects.equals(c.getEmail(), "") || Objects.equals(c.getAddress(), "")) {
            throw new CustomerNotCreatableException("Field cannot be empty!");
        }

        //Customer Email exists validation
        for (Customer cust : CustomerDB.getCustomers()) {
            if (Objects.equals(cust.getEmail(), c.getEmail())) {
                throw new CustomerNotCreatableException("Customer with that Email already exists!");
            }
        }

        //check that customer is 18 years old
        Period ageDifference = Period.between(c.getBirthdate(), LocalDate.now());
        if (ageDifference.getYears() < 18) {
            throw new CustomerNotCreatableException("Customer is not at least 18 years old!");
        }

        CreateCustomerEvent createCustomerEvent = new CreateCustomerEvent();

        createCustomerEvent.setFirstname(c.getFirstname());
        createCustomerEvent.setSurname(c.getSurname());
        createCustomerEvent.setBirthdate(c.getBirthdate());
        createCustomerEvent.setAddress(c.getAddress());
        createCustomerEvent.setEmail(c.getEmail());

        System.out.println("CreateCustomerEvent: " + eventPublisher.publishEvent(createCustomerEvent));

        return true;
    }

    public boolean handleCreateRoomCommand(CreateRoomCommand c) throws RoomNotAddableException {

        //check if room number already exists
        for (Room room : RoomDB.getRooms()) {
            if (Objects.equals(room.getRoomNr(), c.getRoomNr())) {
                throw new RoomNotAddableException("Room with that number already exists!");
            }
        }

        CreateRoomEvent createRoomEvent = new CreateRoomEvent();

        createRoomEvent.setRoomId(c.getRoomId());
        createRoomEvent.setRoomNr(c.getRoomNr());
        createRoomEvent.setFloor(c.getFloor());
        createRoomEvent.setCapacity(c.getCapacity());

        System.out.println("CreateCustomerEvent: " + eventPublisher.publishEvent(createRoomEvent));

        return true;
    }
}