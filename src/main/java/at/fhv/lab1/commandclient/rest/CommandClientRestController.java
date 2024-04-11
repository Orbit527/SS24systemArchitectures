package at.fhv.lab1.commandclient.rest;

import at.fhv.lab1.commandclient.commandHandler.CommandHandler;
import at.fhv.lab1.commandclient.commands.CreateCustomerCommand;
import at.fhv.lab1.commandclient.commands.CreateRoomCommand;
import at.fhv.lab1.commandclient.commands.RoomBookedCommand;
import at.fhv.lab1.commandclient.database.BookingDB;
import at.fhv.lab1.commandclient.database.CustomerDB;
import at.fhv.lab1.commandclient.database.RoomDB;
import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.BookingRest;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Objects;

@RestController
public class CommandClientRestController {

    private final CommandHandler commandHandler;

    public CommandClientRestController() {
        commandHandler = new CommandHandler();
    }

    @PostMapping(value = "/createBooking", consumes = "application/json")
    public String addBooking(@RequestBody BookingRest bookingRest) {
        System.out.println("Booking POST received: " + bookingRest);

        //Convert to real Booking Object
        Booking booking = new Booking();
        booking.setCustomer(CustomerDB.getCustomerById(bookingRest.getCustomerID()));
        booking.setRoom(RoomDB.getRoomById(bookingRest.getRoomID()));
        booking.setStartDate(LocalDate.parse(bookingRest.getStartDate()));
        booking.setEndDate(LocalDate.parse(bookingRest.getEndDate()));

        //Create new Command
        RoomBookedCommand command = new RoomBookedCommand();
        command.setBooking(booking);
        command.setCustomer(booking.getCustomer());
        command.setRoom(booking.getRoom());
        command.setStartDate(booking.getStartDate());
        command.setEndDate(booking.getEndDate());

        //Send command to CommandHandler
        String status = commandHandler.handleRoomBookedCommand(command);
        if (Objects.equals(status, "0")) {
            BookingDB.addBooking(booking);
        } else {
            System.out.println("Something went wrong trying to create createBooking Event!");
            System.out.println(status);
            return status;
        }

        return "Booking created!";
    }

    @PostMapping(value = "/createCustomer", consumes = "application/json")
    public String createCustomer(@RequestBody Customer customer) {
        System.out.println("Create Customer POST received: " +  customer);

        //Create new Command
        CreateCustomerCommand command = new CreateCustomerCommand();
        command.setFirstname(customer.getFirstname());
        command.setSurname(customer.getSurname());
        command.setBirthdate(LocalDate.parse("2001-12-12")); //TODO: Real Date
        command.setEmail(customer.getEmail());
        command.setAddress(customer.getAddress());

        //Send command to CommandHandler
        String status = commandHandler.handleCreateCustomerCommand(command);
        if (Objects.equals(status, "0")) {
            CustomerDB.addCustomer(customer);
            System.out.println(CustomerDB.getCustomers());
        } else {
            System.out.println("Something went wrong trying to create createCustomer Event!");
            System.out.println(status);
            return status;
        };

        return "Customer added!";
    }

    @PostMapping(value = "/createRoom", consumes = "application/json")
    public String addRoom(@RequestBody Room room) {
        System.out.println("Create Room POST received: " +  room);

        //Create new Command
        CreateRoomCommand command = new CreateRoomCommand();
        command.setRoomNr(room.getRoomNr());
        command.setCapacity(room.getCapacity());
        command.setFloor(room.getFloor());

        //Send command to CommandHandler
        String status = commandHandler.handleCreateRoomCommand(command);
        if (Objects.equals(status, "0")) {
            RoomDB.addRoom(room);
            System.out.println(RoomDB.getRooms());
        } else {
            System.out.println("Something went wrong trying to create createRoom Event!");
            System.out.println(status);
            return status;
        };

        return "Room added!";
    }
}
