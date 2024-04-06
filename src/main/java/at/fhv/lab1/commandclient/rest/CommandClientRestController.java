package at.fhv.lab1.commandclient.rest;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commandHandler.CommandHandler;
import at.fhv.lab1.commandclient.commands.CreateCustomerCommand;
import at.fhv.lab1.commandclient.commands.RoomBookedCommand;
import at.fhv.lab1.commandclient.database.BookingDB;
import at.fhv.lab1.commandclient.database.CustomerDB;
import at.fhv.lab1.commandclient.database.RoomDB;
import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.BookingRest;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;
import at.fhv.lab1.eventbus.events.Event;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class CommandClientRestController {

    private final CommandHandler commandHandler;
    CustomerDB customerDB = new CustomerDB();
    RoomDB roomsDB = new RoomDB();
    BookingDB bookingDB = new BookingDB();

    public CommandClientRestController() {
        commandHandler = new CommandHandler();
    }

    @PostMapping(value = "/createBooking", consumes = "application/json")
    public boolean addBooking(@RequestBody BookingRest bookingRest) {
        System.out.println("Booking POST received: " + bookingRest);

        //TODO: create some more mock data

        //Convert to real Booking Object
        Booking booking = new Booking();
        //booking.setCustomer(customers.get(bookingRest.getCustomerId())); //TODO: set real Customer from ID
        booking.setCustomer(CustomerDB.getCustomerById(bookingRest.getCustomerId()));
        //booking.setRoom(rooms.get(bookingRest.getRoomID()));    //TODO: set real Room from ID
        booking.setRoom(RoomDB.getRoomById(bookingRest.getRoomID()));    //TODO: set real Room from ID
        booking.setTimestampStart(bookingRest.getTimestampStart());
        booking.setTimestampEnd(bookingRest.getTimestampEnd());


        //Create new Command
        RoomBookedCommand command = new RoomBookedCommand();
        command.setBooking(booking);
        command.setCustomer(booking.getCustomer());
        command.setRoom(booking.getRoom());
        command.setTimestampStart(booking.getTimestampStart());
        command.setTimestampEnd(booking.getTimestampEnd());

        //Send command to CommandHandler
        if (commandHandler.handleRoomBookedCommand(command)) {
            BookingDB.addBooking(booking);
        } else {
            System.out.println("Something went wrong trying to create createBooking Event");
        };

        return true;
    }

    @PostMapping(value = "/createCustomer", consumes = "application/json")
    public boolean createCustomer(@RequestBody Customer customer) {
        System.out.println("Create Customer POST received: " +  customer);
        
        //Create new Command
        CreateCustomerCommand command = new CreateCustomerCommand();
        command.setFirstname(customer.getFirstname());
        command.setSurname(customer.getSurname());
        command.setEmail(customer.getEmail());
        command.setAddress(customer.getAddress());

        //Send command to CommandHandler
        if (commandHandler.handleCreateCustomerCommand(command)) {
            CustomerDB.addCustomer(customer);
            System.out.println(CustomerDB.getCustomers());
        } else {
            System.out.println("Something went wrong trying to create createCustomer Event");
        };



        return true;
    }
}
