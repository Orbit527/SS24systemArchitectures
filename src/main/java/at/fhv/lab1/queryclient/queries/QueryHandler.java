package at.fhv.lab1.queryclient.queries;

import at.fhv.lab1.queryclient.database.BookingsProjectedDB;
import at.fhv.lab1.queryclient.domain.BookingsProjected;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class QueryHandler {


    private BookingsProjectedDB bookingsProjectedDB;

    public QueryHandler() {
        bookingsProjectedDB = new BookingsProjectedDB();
    }

    public String handleGetBookingsQuery(GetBookingsQuery query) {

        //TODO: handle query
        // retrieve data from DB
        // and send data back

        StringBuilder output = new StringBuilder();

        for(BookingsProjected bp : bookingsProjectedDB.getBookings()) {
            output.append(bp);
        }


        return output.toString();

    }


}
