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

            //Mock data

            //Rooms
            CreateRoomEvent cre1 = new CreateRoomEvent();
            Room r1 = new Room(1, 0, 3);
            cre1.setRoomId(r1.getId());
            cre1.setRoomNr(r1.getRoomNr());
            cre1.setFloor(r1.getFloor());
            cre1.setCapacity(r1.getCapacity());
            RoomDB.addRoom(r1);
            publisher.publishEvent(cre1);

            CreateRoomEvent cre2 = new CreateRoomEvent();
            Room r2 = new Room(2, 0, 2);
            cre2.setRoomId(r2.getId());
            cre2.setRoomNr(r2.getRoomNr());
            cre2.setFloor(r2.getFloor());
            cre2.setCapacity(r2.getCapacity());
            RoomDB.addRoom(r2);
            publisher.publishEvent(cre2);

            CreateRoomEvent cre3 = new CreateRoomEvent();
            Room r3 = new Room(11, 1, 4);
            cre3.setRoomId(r3.getId());
            cre3.setRoomNr(r3.getRoomNr());
            cre3.setFloor(r3.getFloor());
            cre3.setCapacity(r3.getCapacity());
            RoomDB.addRoom(r3);
            publisher.publishEvent(cre3);

            CreateRoomEvent cre4 = new CreateRoomEvent();
            Room r4 = new Room(12, 1, 2);
            cre4.setRoomId(r4.getId());
            cre4.setRoomNr(r4.getRoomNr());
            cre4.setFloor(r4.getFloor());
            cre4.setCapacity(r4.getCapacity());
            RoomDB.addRoom(r4);
            publisher.publishEvent(cre4);

            CreateRoomEvent cre5 = new CreateRoomEvent();
            Room r5 = new Room(21, 2, 2);
            cre5.setRoomId(r5.getId());
            cre5.setRoomNr(r5.getRoomNr());
            cre5.setFloor(r5.getFloor());
            cre5.setCapacity(r5.getCapacity());
            RoomDB.addRoom(r5);
            publisher.publishEvent(cre5);


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

            CreateCustomerEvent cce2 = new CreateCustomerEvent();
            Customer c2 = new Customer("Eva", "Müller", LocalDate.parse("1988-01-06"), "eva.mueller@mail.com", "Gasse 456");
            cce2.setFirstname(c2.getFirstname());
            cce2.setSurname(c2.getSurname());
            cce2.setBirthdate(c2.getBirthdate());
            cce2.setAddress(c2.getAddress());
            cce2.setEmail(c2.getEmail());
            CustomerDB.addCustomer(c2);
            publisher.publishEvent(cce2);

            CreateCustomerEvent cce3 = new CreateCustomerEvent();
            Customer c3 = new Customer("Hans", "Franz", LocalDate.parse("1924-04-17"), "hans.franz@mail.com", "Bach 2");
            cce3.setFirstname(c3.getFirstname());
            cce3.setSurname(c3.getSurname());
            cce3.setBirthdate(c3.getBirthdate());
            cce3.setAddress(c3.getAddress());
            cce3.setEmail(c3.getEmail());
            CustomerDB.addCustomer(c3);
            publisher.publishEvent(cce3);


            //RoomBookedEvents
            RoomBookedEvent rbe1 = new RoomBookedEvent();

            Booking b1 = new Booking();
            b1.setCustomer(c1);
            b1.setRoom(r2);
            b1.setStartDate(LocalDate.parse("2024-04-10"));
            b1.setEndDate(LocalDate.parse("2024-04-15"));

            rbe1.setCustomer(c1);
            rbe1.setRoom(r2);
            rbe1.setBooking(b1);
            rbe1.setStartDate(b1.getStartDate());
            rbe1.setEndDate(b1.getEndDate());

            BookingDB.addBooking(b1);
            publisher.publishEvent(rbe1);


            RoomBookedEvent rbe2 = new RoomBookedEvent();

            Booking b2 = new Booking();
            b2.setCustomer(c2);
            b2.setRoom(r4);
            b2.setStartDate(LocalDate.parse("2024-04-08"));
            b2.setEndDate(LocalDate.parse("2024-04-17"));

            rbe2.setCustomer(c2);
            rbe2.setRoom(r4);
            rbe2.setBooking(b2);
            rbe2.setStartDate(b2.getStartDate());
            rbe2.setEndDate(b2.getEndDate());

            BookingDB.addBooking(b2);
            publisher.publishEvent(rbe2);

        };
    }
}
