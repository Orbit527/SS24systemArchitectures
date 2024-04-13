package at.fhv.lab1.queryclient.rest;

import at.fhv.lab1.eventbus.events.CancelBookingEvent;
import at.fhv.lab1.eventbus.events.CreateCustomerEvent;
import at.fhv.lab1.eventbus.events.CreateRoomEvent;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import at.fhv.lab1.queryclient.database.BookingsProjectedDB;
import at.fhv.lab1.queryclient.database.CustomersProjectedDB;
import at.fhv.lab1.queryclient.database.FreeRoomsProjectedDB;
import at.fhv.lab1.queryclient.domain.BookingProjected;
import at.fhv.lab1.queryclient.domain.CustomerProjected;
import at.fhv.lab1.queryclient.domain.FreeRoomProjected;
import at.fhv.lab1.queryclient.domain.Timeframe;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryRestController {


    public QueryRestController() {
    }

    @PostMapping(value = "/eventRoomBookedAdded", consumes = "application/json")
    public boolean addRoomBookedEvent(@RequestBody RoomBookedEvent event) {

        System.out.println("Event received: " + event);

        BookingProjected bookingProjected = new BookingProjected();

        bookingProjected.setBookingId(event.getBooking().getId());
        bookingProjected.setCapacity(event.getRoom().getCapacity());
        bookingProjected.setCustomerFirstname(event.getCustomer().getFirstname());
        bookingProjected.setCustomerSurname(event.getCustomer().getSurname());
        bookingProjected.setStartDate(event.getStartDate());
        bookingProjected.setEndDate(event.getEndDate());
        bookingProjected.setRoomId(event.getRoom().getId());
        bookingProjected.setRoomNr(event.getRoom().getRoomNr());
        bookingProjected.setFloor(event.getRoom().getFloor());

        BookingsProjectedDB.addBooking(bookingProjected);


        //handle timeFrame setter

        FreeRoomProjected test = FreeRoomsProjectedDB.getRoomById(event.getRoom().getId());
        Timeframe timeframe = new Timeframe(event.getStartDate(), event.getEndDate());
        System.out.println("JAAAAAAAAAAAAAAA" + test + timeframe);

        test.addTimeFrame(timeframe);


        for (BookingProjected bp : BookingsProjectedDB.getBookings()) {
            System.out.println("TEST: " + bp);
        }



        return true;
    }

    @PostMapping(value = "/eventCancelBooking", consumes = "application/json")
    public boolean cancelBookingEvent(@RequestBody CancelBookingEvent event) {
        // TODO: process event through projection

        BookingProjected bookingProjected = BookingsProjectedDB.getBookingById(event.getId());

        System.out.println("REMOVE BOOKING TEST: " + bookingProjected);


        //remove from projected Bookings DB
        BookingsProjectedDB.removeBooking(bookingProjected);

        //remove timeframe from Free Rooms DB
        FreeRoomProjected freeRoomProjected = FreeRoomsProjectedDB.getRoomById(bookingProjected.getRoomId());
        Timeframe timeframe = freeRoomProjected.getTimeFrameByDate(bookingProjected.getStartDate(), bookingProjected.getEndDate());
        freeRoomProjected.removeTimeframe(timeframe);

        System.out.println("Event received: " + event);

        return true;
    }


    @PostMapping(value = "/eventCustomerAdded", consumes = "application/json")
    public boolean addCustomerEvent(@RequestBody CreateCustomerEvent event) {
        System.out.println("Event received: " + event);


        CustomerProjected customerProjected = new CustomerProjected();

        customerProjected.setFirstname(event.getFirstname());
        customerProjected.setSurname(event.getSurname());
        customerProjected.setBirthdate(event.getBirthdate());
        customerProjected.setEmail(event.getEmail());
        customerProjected.setAddress(event.getAddress());

        CustomersProjectedDB.addCustomer(customerProjected);

        //System.out.println("PROJECTED: " + customersProjected);


        for (CustomerProjected bp : CustomersProjectedDB.getCustomers()) {
            System.out.println("TEST: " + bp);
        }





        return true;
    }



    @PostMapping(value = "/roomcreateevent", consumes = "application/json")
    public boolean createRoomEvent(@RequestBody CreateRoomEvent event) {
        // TODO: process event through projection

        FreeRoomProjected freeRoomProjected = new FreeRoomProjected();

        freeRoomProjected.setRoomId(event.getRoomId());
        freeRoomProjected.setRoomNr(event.getRoomNr());
        freeRoomProjected.setFloor(event.getFloor());
        freeRoomProjected.setCapacity(event.getCapacity());

        FreeRoomsProjectedDB.addFreeRoom(freeRoomProjected);

        for(FreeRoomProjected frp : FreeRoomsProjectedDB.getFreeRooms()) {
            System.out.println("FREE ROOMS DB: " + frp);
        }


        System.out.println("Event received: " + event);

        return true;
    }

}
