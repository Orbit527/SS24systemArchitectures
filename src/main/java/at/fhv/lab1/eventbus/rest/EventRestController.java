package at.fhv.lab1.eventbus.rest;

import at.fhv.lab1.eventbus.EventPublisher;
import at.fhv.lab1.eventbus.EventRepository;
import at.fhv.lab1.eventbus.events.CreateCustomerEvent;
import at.fhv.lab1.eventbus.events.CreateRoomEvent;
import at.fhv.lab1.eventbus.events.Event;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventRestController {

    private final EventRepository repository;

    private final EventPublisher publisher;

    public EventRestController(EventRepository repository, EventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @PostMapping(value = "/event", consumes = "application/json")
    public boolean addEvent(@RequestBody Event event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/roombookedevent", consumes = "application/json")
    public boolean addRoomBookedEvent(@RequestBody RoomBookedEvent event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        publisher.publishEvent(event);
        return true;
    }

    @PostMapping(value = "/customercreateevent", consumes = "application/json")
    public boolean customerCreatedEvent(@RequestBody CreateCustomerEvent event) {
        // TODO: process event in repository
        //repository.processEvent(event); TODO: Add in Eventbus
        System.out.println("Event received: " + event);
        publisher.publishEvent(event);
        return true;
    }

    @PostMapping(value = "/roomcreateevent", consumes = "application/json")
    public boolean roomCreatedEvent(@RequestBody CreateRoomEvent event) {
        // TODO: process event in repository
        //repository.processEvent(event); TODO: Add in Eventbus
        System.out.println("Event received: " + event);
        publisher.publishEvent(event);
        return true;
    }
}
