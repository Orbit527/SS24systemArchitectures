package at.fhv.lab1.commandclient.commandHandler;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commands.CreateCustomerCommand;
import at.fhv.lab1.commandclient.commands.RoomBookedCommand;
import at.fhv.lab1.commandclient.database.BookingDB;
import at.fhv.lab1.commandclient.database.CustomerDB;
import at.fhv.lab1.commandclient.database.RoomDB;
import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommandHandler {

    private final EventPublisher eventPublisher;
    //private RoomDB roomDB;


    public CommandHandler() {
        eventPublisher = new EventPublisher();
        //roomDB = new RoomDB();
    }

    public boolean handleRoomBookedCommand(RoomBookedCommand r) {

        //TODO: Validate before creating event

        //TODO: check booking by timestamp
        //TODO: check booking, if customer and room id exists
        /*
        if(RoomDB.getRoomById(r.getRoom().getId()).isCurrentlyBooked() == true) {
            System.out.println("Room is already booked!");
            return false;
        }
         */

        List<Customer> customerWithId1 = CustomerDB.getCustomers()
                .stream()
                .filter(c -> c.getId() == 1)
                .collect(Collectors.toList());

        for (Customer c : customerWithId1 ) {
            System.out.println("CUSTOMER WITH ID 1: " + c);
        }


        RoomBookedEvent roomBookedEvent = new RoomBookedEvent();

        roomBookedEvent.setCustomer(r.getCustomer());
        roomBookedEvent.setRoom(r.getRoom());
        roomBookedEvent.setBooking(r.getBooking()); //TODO: add real parameters
        roomBookedEvent.setBookedStart(r.getBookedStart());
        roomBookedEvent.setBookedEnd(r.getBookedEnd());

        //System.out.println(roomBookedEvent);



        //set that Room is now booked
        //RoomDB.getRoomById(r.getRoom().getId()).setCurrentlyBooked(true);

        //System.out.println("ROOM WITH ID 0: " + RoomDB.getRoomById(2));


        System.out.println("BookRoomEvent: " + eventPublisher.publishEvent(roomBookedEvent));

        //TODO: sent true or false, if something fails or not
        return true;
    }

    public boolean handleCreateCustomerCommand(CreateCustomerCommand c) {


        //Customer Email exists validation
        for(Customer cust : CustomerDB.getCustomers()) {
            if (Objects.equals(cust.getEmail(), c.getEmail())) {
                System.out.println("Customer with that email already exists!");
                return false;
            }
        }

        //TODO: further Validation

        //TODO: Create Event and send to EventBus

        return true;

    }

}
