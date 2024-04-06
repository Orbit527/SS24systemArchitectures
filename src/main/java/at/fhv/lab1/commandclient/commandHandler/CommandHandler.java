package at.fhv.lab1.commandclient.commandHandler;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commands.RoomBookedCommand;
import at.fhv.lab1.commandclient.database.BookingDB;
import at.fhv.lab1.commandclient.database.CustomerDB;
import at.fhv.lab1.commandclient.database.RoomDB;
import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;

public class CommandHandler {

    private final EventPublisher eventPublisher;
    //private RoomDB roomDB;


    public CommandHandler() {
        eventPublisher = new EventPublisher();
        //roomDB = new RoomDB();
    }

    public boolean handleRoomBookedCommand(RoomBookedCommand r) {

        //TODO: Validate before creating event

        //TODO: check booking by timestamp, not by boolean
        if(RoomDB.getRoomById(r.getRoom().getId()).isCurrentlyBooked() == true) {
            System.out.println("Room is already booked");
            return false;
        }


        //TODO: make sure error is thrown, when there is no user with id

        RoomBookedEvent roomBookedEvent = new RoomBookedEvent();

        roomBookedEvent.setCustomer(r.getCustomer());
        roomBookedEvent.setRoom(r.getRoom());
        roomBookedEvent.setBooking(r.getBooking()); //TODO: add real parameters
        roomBookedEvent.setTimestampStart(r.getTimestampStart());
        roomBookedEvent.setTimestampEnd(r.getTimestampEnd());

        System.out.println(roomBookedEvent);



        //set that Room is now booked
        RoomDB.getRoomById(r.getRoom().getId()).setCurrentlyBooked(true);

        //System.out.println("ROOM WITH ID 0: " + RoomDB.getRoomById(2));


        System.out.println("BookRoomEvent: " + eventPublisher.publishEvent(roomBookedEvent));

        //TODO: sent true or false, if something fails or not
        return true;
    }
}
