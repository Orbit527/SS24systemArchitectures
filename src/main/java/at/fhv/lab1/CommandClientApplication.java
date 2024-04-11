package at.fhv.lab1;

import at.fhv.lab1.commandclient.commands.CreateRoomCommand;
import at.fhv.lab1.commandclient.database.BookingDB;
import at.fhv.lab1.commandclient.database.CustomerDB;
import at.fhv.lab1.commandclient.database.RoomDB;
import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;
import at.fhv.lab1.eventbus.events.CreateCustomerEvent;
import at.fhv.lab1.eventbus.events.CreateRoomEvent;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import at.fhv.lab1.commandclient.EventPublisher;

import java.time.LocalDate;

@SpringBootApplication
@Configuration
@ComponentScan("at.fhv.lab1.commandclient")
public class CommandClientApplication {

    //set once, so that DBs are available
    CustomerDB customerDB = new CustomerDB();
    RoomDB roomsDB = new RoomDB();
    BookingDB bookingDB = new BookingDB();
    private final EventPublisher publisher;

    public CommandClientApplication(EventPublisher publisher) {
        this.publisher = publisher;
    }

    public static void main(String[] args) {
        SpringApplication.run(CommandClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            /*
            Event event = new Event();
            event.setContent("This is the content!");
            event.setCustomer("Customer1");
            event.setTimestamp(System.currentTimeMillis());
            System.out.println("Result: " + publisher.publishEvent(event));
            */

            //Mock data
            /*
            RoomDB.addRoom(new Room(1, 0, 2));
            RoomDB.addRoom(new Room(2, 0, 4));
            RoomDB.addRoom(new Room(3, 0, 3));
            RoomDB.addRoom(new Room(11, 1, 1));
            RoomDB.addRoom(new Room(12, 1, 1));
            RoomDB.addRoom(new Room(13, 1, 6));
            RoomDB.addRoom(new Room(21, 2, 2));
             */

            //Rooms
            CreateRoomEvent cre1 = new CreateRoomEvent();
            Room r1 = new Room(1, 0, 3);
            cre1.setRoomNr(r1.getRoomNr());
            cre1.setFloor(r1.getFloor());
            cre1.setCapacity(r1.getCapacity());
            RoomDB.addRoom(r1);
            publisher.publishEvent(cre1);

/*
            CustomerDB.addCustomer(new Customer("Max", "Mustermann", LocalDate.parse("2001-11-12"), "max.mustermann@max.com", "Straße 123"));
            CustomerDB.addCustomer(new Customer("Eva", "Müller", LocalDate.parse("2001-11-12"), "eva.mueller@123.com", "Coole Adresse 52"));
            CustomerDB.addCustomer(new Customer("Hans", "Franz", LocalDate.parse("2001-11-12"), "hans.franz@mail.com", "Bach 8234"));
*/
            //Customers
            CreateCustomerEvent cce1 = new CreateCustomerEvent();
            Customer c1 = new Customer("Max", "Mustermann", LocalDate.parse("2001-11-12"), "max.mustermann@max.com", "Straße 123");
            cce1.setFirstname(c1.getFirstname());
            cce1.setSurname(c1.getSurname());
            cce1.setBirthdate(c1.getBirthdate());
            cce1.setAddress(c1.getAddress());
            cce1.setEmail(c1.getEmail());
            CustomerDB.addCustomer(c1);
            publisher.publishEvent(cce1);

            //TODO: add more, when all events are implemented!!

            //RoomBookedEvents
            RoomBookedEvent roomBookedEvent = new RoomBookedEvent();

            Booking b = new Booking();
            b.setCustomer(c1);
            b.setRoom(r1);
            b.setStartDate(LocalDate.parse("2024-04-10"));
            b.setEndDate(LocalDate.parse("2024-04-15"));

            roomBookedEvent.setCustomer(c1); //TODO: real customer
            roomBookedEvent.setRoom(r1); //TODO: real parameters
            roomBookedEvent.setBooking(b); //TODO: add real parameters
            roomBookedEvent.setStartDate(b.getStartDate());
            roomBookedEvent.setEndDate(b.getEndDate());

            BookingDB.addBooking(b);
            publisher.publishEvent(roomBookedEvent);

        };
    }
}
