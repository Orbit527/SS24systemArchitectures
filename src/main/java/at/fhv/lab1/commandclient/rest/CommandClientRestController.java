package at.fhv.lab1.commandclient.rest;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commandHandler.CommandHandler;
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
    private final ArrayList<Customer> customers;
    RoomDB roomsDB = new RoomDB();
    private final ArrayList<Room> rooms;
    BookingDB bookingDB = new BookingDB();
    private final ArrayList<Booking> bookings;

    public CommandClientRestController() {
        commandHandler = new CommandHandler();
        customers = customerDB.getCustomers();
        rooms = roomsDB.getRooms();
        bookings = bookingDB.getBookings();
    }

    @PostMapping(value = "/createBooking", consumes = "application/json")
    public boolean addBooking(@RequestBody BookingRest bookingRest) {
        System.out.println("Booking received: " + bookingRest);

        //TODO: create some more mock data

        //Convert to real Booking Object
        Booking booking = new Booking();
        booking.setCustomer(customers.get(bookingRest.getCustomerId())); //TODO: set real Customer from ID
        booking.setRoom(rooms.get(bookingRest.getRoomID()));    //TODO: set real Room from ID
        booking.setTimestampStart(bookingRest.getTimestampStart());
        booking.setTimestampEnd(bookingRest.getTimestampEnd());


        //Create new Command
        RoomBookedCommand command = new RoomBookedCommand();
        command.setBooking(booking); //TODO real param
        command.setCustomer(booking.getCustomer()); //TODO real param
        command.setRoom(booking.getRoom());    //TODO real param
        command.setTimestampStart(booking.getTimestampStart());
        command.setTimestampEnd(booking.getTimestampEnd());

        //Send command to CommandHandler
        if (commandHandler.handleRoomBookedCommand(command)) {
            bookings.add(booking);
        } else {
            System.out.println("Something went wrong, when creating the Event");
        };

        return true;
    }

    @PostMapping(value = "/createCustomer", consumes = "application/json")
    public boolean createCustomer(@RequestBody Customer customer) {
        System.out.println("Booking received: " +  customer);

        //TODO: create some more mock data

        //Convert to real Booking Object
        /*
        Booking booking = new Booking();
        booking.setCustomer(customers.get(bookingRest.getCustomerId())); //TODO: set real Customer from ID
        booking.setRoom(rooms.get(bookingRest.getRoomID()));    //TODO: set real Room from ID
        booking.setTimestampStart(bookingRest.getTimestampStart());
        booking.setTimestampEnd(bookingRest.getTimestampEnd());


        //Create new Command
        RoomBookedCommand command = new RoomBookedCommand();
        command.setBooking(booking); //TODO real param
        command.setCustomer(booking.getCustomer()); //TODO real param
        command.setRoom(booking.getRoom());    //TODO real param
        command.setTimestampStart(booking.getTimestampStart());
        command.setTimestampEnd(booking.getTimestampEnd());

        //Send command to CommandHandler
        if (commandHandler.handleRoomBookedCommand(command)) {
            bookings.add(booking);
        } else {
            System.out.println("Something went wrong, when creating the Event");
        };

         */

        return true;
    }
}
