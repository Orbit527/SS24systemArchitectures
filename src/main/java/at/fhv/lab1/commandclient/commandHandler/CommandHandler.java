package at.fhv.lab1.commandclient.commandHandler;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commands.RoomBookedCommand;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;

import javax.sound.midi.SysexMessage;

public class CommandHandler {

    private final EventPublisher eventPublisher;

    public CommandHandler() {
        eventPublisher = new EventPublisher();
    }


    public boolean handleCommand(RoomBookedCommand r) {

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

        return true;
    }
}
