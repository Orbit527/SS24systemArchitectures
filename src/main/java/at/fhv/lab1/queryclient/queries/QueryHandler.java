package at.fhv.lab1.queryclient.queries;

import at.fhv.lab1.commandclient.database.BookingDB;
import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.queryclient.database.BookingsProjectedDB;
import at.fhv.lab1.queryclient.domain.BookingsProjected;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.v3.core.util.Json;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
}
