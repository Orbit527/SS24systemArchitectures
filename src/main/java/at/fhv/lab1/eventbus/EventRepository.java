package at.fhv.lab1.eventbus;

import at.fhv.lab1.eventbus.events.Event;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventRepository {

    private final List<Event> events = new ArrayList<>();

    public void processEvent(Event event) {
        // TODO: store events in log/DB
        events.add(event);
        // TODO: notify subscribed read repositories
        System.out.println("Processing Event");
    }

    public void processEvent(RoomBookedEvent event) {
        // TODO: store events in log/DB
        //events.add(event);
        // TODO: notify subscribed read repositories
        System.out.println("Processing Event");
    }


}
