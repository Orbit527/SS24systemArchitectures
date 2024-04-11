package at.fhv.lab1.commandclient.commandHandler;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commands.CreateCustomerCommand;
import at.fhv.lab1.commandclient.commands.CreateRoomCommand;
import at.fhv.lab1.commandclient.commands.RoomBookedCommand;
import at.fhv.lab1.commandclient.database.BookingDB;
import at.fhv.lab1.commandclient.database.CustomerDB;
import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.eventbus.events.CreateCustomerEvent;
import at.fhv.lab1.eventbus.events.CreateRoomEvent;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;

import java.util.Objects;

public class CommandHandler {

    private final EventPublisher eventPublisher;

    public CommandHandler() {
        eventPublisher = new EventPublisher();
    }

    public String handleRoomBookedCommand(RoomBookedCommand r) {

        //check for empty fields
        if (r.getBooking() == null || r.getEndDate() == null || r.getStartDate() == null) {
            return "Fields cannot be empty!";
        }

        //check if Customer with that Id exists
        if (r.getCustomer() == null) {
            return "Customer with that ID does not exist!";
        }

        //check if Room with that Id exists
        if (r.getRoom() == null) {
            return "Room with that ID does not exist!";
        }

        //check that endDate is after startDate
        if (r.getEndDate().isBefore(r.getStartDate())) {
            return "Enddate is before Startdate!";
        }

        //check for overlapping date
        //TODO: check for single day booking
        for (Booking b : BookingDB.getBookings()) {
            //Booking has to be on the same room
            if (b.getRoom().getId() == r.getRoom().getId()) {
                if(b.getStartDate().isBefore(r.getEndDate()) && b.getEndDate().isAfter(r.getStartDate())) {
                    return "There is a booking already in this timeframe!";
                }
            }
        }


        /*
        List<Customer> customerWithId1 = CustomerDB.getCustomers()
                .stream()
                .filter(c -> c.getId() == 1)
                .collect(Collectors.toList());

        for (Customer c : customerWithId1 ) {
            System.out.println("CUSTOMER WITH ID 1: " + c);
        }
        */


        RoomBookedEvent roomBookedEvent = new RoomBookedEvent();

        roomBookedEvent.setCustomer(r.getCustomer());
        roomBookedEvent.setRoom(r.getRoom());
        roomBookedEvent.setBooking(r.getBooking()); //TODO: add real parameters
        roomBookedEvent.setStartDate(r.getStartDate());
        roomBookedEvent.setEndDate(r.getEndDate());

        System.out.println("BookRoomEvent: " + eventPublisher.publishEvent(roomBookedEvent));

        return "0";
    }

    public String handleCreateCustomerCommand(CreateCustomerCommand c) {

        //check for empty fields
        if (c.getFirstname() == "" || c.getSurname() == "" || c.getEmail() == "" || c.getAddress() == "") {
            return "Field cannot be empty!";
        }

        //Customer Email exists validation
        for (Customer cust : CustomerDB.getCustomers()) {
            if (Objects.equals(cust.getEmail(), c.getEmail())) {
                return "Customer with that Email already exists!";
            }
        }

        //TODO: further Validation

        //TODO: Create Event and send to EventBus
        CreateCustomerEvent createCustomerEvent = new CreateCustomerEvent();

        createCustomerEvent.setFirstname(c.getFirstname());
        createCustomerEvent.setSurname(c.getSurname());
        createCustomerEvent.setBirthdate(c.getBirthdate());
        createCustomerEvent.setAddress(c.getAddress());
        createCustomerEvent.setEmail(c.getEmail());

        System.out.println("CreateCustomerEvent: " + eventPublisher.publishEvent(createCustomerEvent));

        return "0";

    }

    public String handleCreateRoomCommand(CreateRoomCommand c) {

        //TODO: further Validation

        //TODO: check that room Number is unique

        //TODO: Create Event and send to EventBus
        CreateRoomEvent createRoomEvent = new CreateRoomEvent();

        createRoomEvent.setRoomNr(c.getRoomNr());
        createRoomEvent.setFloor(c.getFloor());
        createRoomEvent.setCapacity(c.getCapacity());

        System.out.println("CreateCustomerEvent: " + eventPublisher.publishEvent(createRoomEvent));


        return "0";

    }

}
