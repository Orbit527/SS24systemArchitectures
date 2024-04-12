package at.fhv.lab1;

import at.fhv.lab1.queryclient.database.BookingsProjectedDB;
import at.fhv.lab1.queryclient.database.CustomersProjectedDB;
import at.fhv.lab1.queryclient.database.FreeRoomsProjectedDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("at.fhv.lab1.queryclient")
public class QueryClientApplication {

    private BookingsProjectedDB bookingsProjectedDB = new BookingsProjectedDB();
    private CustomersProjectedDB customersProjectedDB = new CustomersProjectedDB();
    private FreeRoomsProjectedDB freeRoomsProjectedDB = new FreeRoomsProjectedDB();

    public static void main(String[] args) {
        SpringApplication.run(QueryClientApplication.class, args);
    }

}
