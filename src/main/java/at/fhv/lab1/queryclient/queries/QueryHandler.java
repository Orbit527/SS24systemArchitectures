package at.fhv.lab1.queryclient.queries;

import at.fhv.lab1.commandclient.database.BookingDB;
import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.queryclient.database.BookingsProjectedDB;
import at.fhv.lab1.queryclient.database.CustomersProjectedDB;
import at.fhv.lab1.queryclient.domain.BookingsProjected;
import at.fhv.lab1.queryclient.domain.CustomersProjected;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.v3.core.util.Json;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class QueryHandler {

    public QueryHandler() {

    }

    public String handleGetBookingsQuery(GetBookingsQuery query) {

        //TODO: handle query
        // retrieve data from DB
        // and send data back

        System.out.println(query.getStartDate());
        System.out.println(query.getEndDate());

        //check that Bookings are in timeframe
        //TODO: add Array and return array in JSON

        StringBuilder output = new StringBuilder();
        output.append("{\"bookings\": [");

        //TODO: remove last colon

        for (BookingsProjected b : BookingsProjectedDB.getBookings()) {
            if(b.getStartDate().isBefore(query.getEndDate()) && b.getEndDate().isAfter(query.getStartDate())) {
                output.append(b.toString());
                output.append(",");
            }
        }



        output.append("]}");

        return output.toString();

        /*

        for(BookingsProjected bp : bookingsProjectedDB.getBookings()) {

        }



         */
    }

    public String handleGetCustomersQuery(GetCustomersQuery query) {

        //TODO: handle query
        // retrieve data from DB
        // and send data back

        System.out.println(query.getFirstname());
        System.out.println(query.getSurname());

        StringBuilder output = new StringBuilder();
        output.append("{\"customers\": [");

        //TODO!
        /*
        // check if firstname is set in query
        if(!Objects.equals(query.getFirstname(), "null")) {
            ArrayList<CustomersProjected> test = CustomersProjectedDB.getCustomerByFirstname(query.getFirstname());
            System.out.println("PEOPLE WITH FIRSTNAME: " + test);
        }

        // check if surname is set in query
        if(!Objects.equals(query.getSurname(), "null")) {
            ArrayList<CustomersProjected> test = CustomersProjectedDB.getCustomerByFirstname(query.getFirstname());
            System.out.println("PEOPLE WITH SURNAME: " + test);
        }

        //check if both firstname and surname are set
        if(!Objects.equals(query.getFirstname(), "null") && !Objects.equals(query.getSurname(), "null")) {
            ArrayList<CustomersProjected> test = CustomersProjectedDB.getCustomerByFirstAndSurname(query.getFirstname(), query.getSurname());
            System.out.println("PEOPLE WITH FIRST AND SURNAME: " + test);
        }

         */


        //TODO: remove last colon

        for (CustomersProjected c : CustomersProjectedDB.getCustomers()) {
            //check for firstname and lastname
                output.append(c.toString());
                output.append(",");

        }

        output.append("]}");

        return output.toString();


    }



}
