package at.fhv.lab1;

import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;
import at.fhv.lab1.eventbus.events.Event;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import at.fhv.lab1.commandclient.EventPublisher;

@SpringBootApplication
@Configuration
@ComponentScan("at.fhv.lab1.commandclient")
public class CommandClientApplication {

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
            Event event = new Event();
            event.setContent("This is the content!");
            event.setCustomer("Customer1");
            event.setTimestamp(System.currentTimeMillis());
            System.out.println("Result: " + publisher.publishEvent(event));

            /*
            RoomBookedEvent rbevent = new RoomBookedEvent();
            rbevent.setCustomer(new Customer());
            rbevent.setTimestampStart(12343214);
            rbevent.setBookingID(1);
            rbevent.setRoom(new Room());
            publisher.publishEvent(rbevent);

             */
        };
    }
}
