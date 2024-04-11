package at.fhv.lab1.queryclient.rest;

import at.fhv.lab1.eventbus.events.CreateCustomerEvent;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import at.fhv.lab1.queryclient.database.BookingsProjectedDB;
import at.fhv.lab1.queryclient.domain.BookingsProjected;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryRestController {

    private BookingsProjectedDB bookingsProjectedDB;

    public QueryRestController() {
        bookingsProjectedDB = new BookingsProjectedDB();
    }

    @PostMapping(value = "/eventRoomBookedAdded", consumes = "application/json")
    public boolean addRoomBookedEvent(@RequestBody RoomBookedEvent event) {
        // TODO: process event through projection

        System.out.println("Event received: " + event);



        BookingsProjected bookingsProjected = new BookingsProjected();
        bookingsProjected.setCapacity(event.getRoom().getCapacity());
        bookingsProjected.setCustomerFirstname(event.getCustomer().getFirstname());
        bookingsProjected.setCustomerSurname(event.getCustomer().getSurname());
        bookingsProjected.setStartDate(event.getStartDate());
        bookingsProjected.setEndDate(event.getEndDate());
        bookingsProjected.setRoomNr(event.getRoom().getRoomNr());
        bookingsProjected.setFloor(event.getRoom().getFloor());

        bookingsProjectedDB.addBooking(bookingsProjected);


        for (BookingsProjected bp : bookingsProjectedDB.getBookings()) {
            System.out.println("TEST: " + bp);
        }



        return true;
    }

    @PostMapping(value = "/eventCustomerAdded", consumes = "application/json")
    public boolean addCustomerEvent(@RequestBody CreateCustomerEvent event) {
        // TODO: process event through projection

        //TODO: add to DB

        System.out.println("Event received: " + event);

        return true;
    }

}
