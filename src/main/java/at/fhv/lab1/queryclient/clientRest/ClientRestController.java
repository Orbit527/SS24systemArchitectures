package at.fhv.lab1.queryclient.clientRest;

import at.fhv.lab1.queryclient.queries.GetBookingsQuery;
import at.fhv.lab1.queryclient.queries.GetCustomersQuery;
import at.fhv.lab1.queryclient.queries.GetFreeRoomsQuery;
import at.fhv.lab1.queryclient.queries.QueryHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientRestController {

    private QueryHandler queryHandler;

    public ClientRestController() {
        queryHandler = new QueryHandler();
    }

    @PostMapping(value = "/getBookings")
    public String getBookings(@RequestBody GetBookingsRest getBookingsRest) {

        GetBookingsQuery getBookingsQuery = new GetBookingsQuery();

        getBookingsQuery.setStartDate(getBookingsRest.getStartDate());
        getBookingsQuery.setEndDate(getBookingsRest.getEndDate());

        return queryHandler.handleGetBookingsQuery(getBookingsQuery);

    }

    @PostMapping(value = "/getFreeRooms")
    public String getBookings(@RequestBody GetFreeRoomsRest getFreeRoomsRest) {

        GetFreeRoomsQuery getFreeRoomsQuery = new GetFreeRoomsQuery();

        getFreeRoomsQuery.setStartDate(getFreeRoomsRest.getStartDate());
        getFreeRoomsQuery.setEndDate(getFreeRoomsRest.getEndDate());
        getFreeRoomsQuery.setPersonCount(getFreeRoomsRest.getPersonCount());

        return queryHandler.handleGetFreeRoomsQuery(getFreeRoomsQuery);

    }

    @PostMapping(value = "/getCustomers")
    public String getBookings(@RequestBody GetCustomersRest getCustomersRest) {

        GetCustomersQuery getCustomersQuery = new GetCustomersQuery();

        getCustomersQuery.setFirstname(getCustomersRest.getFirstname());
        getCustomersQuery.setSurname(getCustomersRest.getSurname());

        return queryHandler.handleGetCustomersQuery(getCustomersQuery);

    }

}
