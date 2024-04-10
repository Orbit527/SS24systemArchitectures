package at.fhv.lab1;

import at.fhv.lab1.commandclient.database.BookingDB;
import at.fhv.lab1.commandclient.database.CustomerDB;
import at.fhv.lab1.commandclient.database.RoomDB;
import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;
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
            RoomDB.addRoom(new Room(1, 0, 2));
            RoomDB.addRoom(new Room(2, 0, 4));
            RoomDB.addRoom(new Room(3, 0, 3));
            RoomDB.addRoom(new Room(11, 1, 1));
            RoomDB.addRoom(new Room(12, 1, 1));
            RoomDB.addRoom(new Room(13, 1, 6));
            RoomDB.addRoom(new Room(21, 2, 2));

            //TODO: add more, when all events are implemented!!

            RoomBookedEvent roomBookedEvent = new RoomBookedEvent();

            Customer c = new Customer("Hans", "Joerg", "hans.joerg@email.com", "strasse 123");
            Room r = new Room(1, 0, 2 );
            Booking b = new Booking();
            b.setCustomer(c);
            b.setRoom(r);
            b.setStartDate(LocalDate.parse("2024-04-10"));
            b.setEndDate(LocalDate.parse("2024-04-15"));

            roomBookedEvent.setCustomer(c); //TODO: real customer
            roomBookedEvent.setRoom(r); //TODO: real parameters
            roomBookedEvent.setBooking(b); //TODO: add real parameters
            roomBookedEvent.setStartDate(b.getStartDate());
            roomBookedEvent.setEndDate(b.getEndDate());

            publisher.publishEvent(roomBookedEvent);
            BookingDB.addBooking(b);



        };
    }
}
