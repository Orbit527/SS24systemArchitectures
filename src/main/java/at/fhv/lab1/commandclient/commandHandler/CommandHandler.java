package at.fhv.lab1.commandclient.commandHandler;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commands.RoomBookedCommand;
import at.fhv.lab1.commandclient.database.BookingDB;
import at.fhv.lab1.commandclient.database.CustomerDB;
import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;

public class CommandHandler {

    private final EventPublisher eventPublisher;


    public CommandHandler() {
        eventPublisher = new EventPublisher();
    }


    public boolean handleRoomBookedCommand(RoomBookedCommand r) {

        //TODO: Validate before creating event

        //TODO: make sure error is thrown, when there is no user with id

        RoomBookedEvent roomBookedEvent = new RoomBookedEvent();

        roomBookedEvent.setCustomer(r.getCustomer());
        roomBookedEvent.setRoom(r.getRoom());
        roomBookedEvent.setBooking(r.getBooking()); //TODO: add real parameters
        roomBookedEvent.setTimestampStart(r.getTimestampStart());
        roomBookedEvent.setTimestampEnd(r.getTimestampEnd());

        System.out.println(roomBookedEvent);



        System.out.println("BookRoomEvent: " + eventPublisher.publishEvent(roomBookedEvent));

        //TODO: sent true or false, if something fails or not
        return true;
    }
}
