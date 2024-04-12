package at.fhv.lab1;

import at.fhv.lab1.queryclient.database.BookingsProjectedDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("at.fhv.lab1.queryclient")
public class QueryClientApplication {

    private BookingsProjectedDB bookingsProjectedDB = new BookingsProjectedDB();

    public static void main(String[] args) {
        SpringApplication.run(QueryClientApplication.class, args);
    }

}
