package at.fhv.lab1.queryclient.clientRest;

import at.fhv.lab1.commandclient.domain.BookingRest;
import at.fhv.lab1.queryclient.queries.GetBookingsQuery;
import at.fhv.lab1.queryclient.queries.QueryHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class clientRest {

    private QueryHandler queryHandler;

    public clientRest() {
        queryHandler = new QueryHandler();
    }

    @GetMapping(value = "/getBookings")
    public String getBookings() {

        GetBookingsQuery getBookingsQuery = new GetBookingsQuery();

        return queryHandler.handleGetBookingsQuery(getBookingsQuery);
    }

    
}
