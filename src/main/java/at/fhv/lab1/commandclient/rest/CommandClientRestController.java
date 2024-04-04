package at.fhv.lab1.commandclient.rest;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commandHandler.CommandHandler;
import at.fhv.lab1.commandclient.commands.RoomBookedCommand;
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

@RestController
public class CommandClientRestController {

    private CommandHandler commandHandler;

    public CommandClientRestController() {
        commandHandler = new CommandHandler();
    }

    @PostMapping(value = "/createBooking", consumes = "application/json")
    public boolean addBooking(@RequestBody BookingRest bookingRest) {
        System.out.println("Booking received: " + bookingRest);

        //TODO: create some mock data
        Customer c1 = new Customer();
        c1.setAddress("Straße 123");
        c1.setFirstname("Max");
        c1.setSurname("Mustermann");
        c1.setEmail("max.mustermann@max.com");

        Room r1 = new Room();
        r1.setRoomNr(10);
        r1.setCapacity(4);
        r1.setCurrentlyBooked(false);
        r1.setFloor(2);

        //Convert to real Booking Object
        Booking booking = new Booking();
        booking.setCustomer(c1); //TODO: set real Customer from ID
        booking.setRoom(r1);    //TODO: set real Room from ID
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
        commandHandler.handleCommand(command);

        // create Event and set Parameters
        //TODO: add missing parameters

        /*

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);



        Event event = new Event();
        event.setCustomer("Holger");




        HttpEntity<Event> request = new HttpEntity<>(event, headers);

        ResponseEntity<Boolean> response = restTemplate.postForEntity("http://localhost:8080/event", request, Boolean.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            Boolean result = response.getBody();
            System.out.println("Event sent successfully: " + result);
        } else {
            System.out.println("Failed to sent event");
        }

         */

        return true;
    }
}
