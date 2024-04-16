package at.fhv.lab1.queryclient.queries;

import at.fhv.lab1.queryclient.database.BookingsProjectedDB;
import at.fhv.lab1.queryclient.database.CustomersProjectedDB;
import at.fhv.lab1.queryclient.database.FreeRoomsProjectedDB;
import at.fhv.lab1.queryclient.domain.BookingProjected;
import at.fhv.lab1.queryclient.domain.CustomerProjected;
import at.fhv.lab1.queryclient.domain.FreeRoomProjected;
import at.fhv.lab1.queryclient.domain.Timeframe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class QueryHandler {

    public QueryHandler() {

    }

    public String handleGetBookingsQuery(GetBookingsQuery query) {

        System.out.println(query.getStartDate());
        System.out.println(query.getEndDate());

        //check that Bookings are in timeframe
        StringBuilder output = new StringBuilder();
        output.append("{\"bookings\": [");

        for (BookingProjected b : BookingsProjectedDB.getBookings()) {
            if(b.getStartDate().isBefore(query.getEndDate().plusDays(1)) && b.getEndDate().isAfter(query.getStartDate().minusDays(1))) {
                output.append(b.toString());
                output.append(",");
            }
        }

        output.append("]}");

        //print out for CLR
        System.out.println(output);

        return output.toString();
    }

    public String handleGetFreeRoomsQuery(GetFreeRoomsQuery query) {

        System.out.println(query);

        System.out.println(FreeRoomsProjectedDB.getFreeRooms());

        //filter according to personCount
        List<FreeRoomProjected> roomsFilteredByCapacity = FreeRoomsProjectedDB.getFreeRooms()
                .stream()
                .filter(c -> c.getCapacity() == query.getPersonCount())
                .collect(Collectors.toList());

        StringBuilder output = new StringBuilder();
        output.append("{\"freeRooms\": [");

        //test for overlapping timeframes
        for(FreeRoomProjected f : roomsFilteredByCapacity) {
            if(hasOverlap(f.getTimeframes(), query.getStartDate(), query.getEndDate()) == false) {
                output.append(f);
                output.append(",");
            }
        }

        output.append("]}");
        //print out for CLR
        System.out.println(output);

        return output.toString();
    }

    private boolean hasOverlap(ArrayList<Timeframe> timeframes, LocalDate newStartDate, LocalDate newEndDate) {
        for (Timeframe timeframe : timeframes) {
            if (newStartDate.isBefore(timeframe.getEndDate().plusDays(1)) && timeframe.getStartDate().minusDays(1).isBefore(newEndDate)) {
                return true;
            }
        }
        return false;
    }


    public String handleGetCustomersQuery(GetCustomersQuery query) {

        ArrayList<CustomerProjected> queryResult;

        //check which fields are set
        if ((query.getFirstname() != null && !query.getFirstname().isEmpty()) && (query.getSurname() != null && !query.getSurname().isEmpty())) {
            //first and surname are stated
            queryResult = CustomersProjectedDB.getCustomerByFirstAndSurname(query.getFirstname(), query.getSurname());
        } else if ((query.getFirstname() == null || query.getFirstname().isEmpty()) && (query.getSurname() == null || query.getSurname().isEmpty())) {
            //no name is stated
            queryResult = CustomersProjectedDB.getCustomers();
        } else {
            //either first or surname is stated
            if(!Objects.equals(query.getFirstname(), "null") && !query.getFirstname().isEmpty()) {
                queryResult = CustomersProjectedDB.getCustomerByFirstname(query.getFirstname());
            } else {
                queryResult = CustomersProjectedDB.getCustomerBySurname(query.getSurname());
            }
        }

        StringBuilder output = new StringBuilder();
        output.append("{\"customers\": [");

        for (CustomerProjected c : queryResult) {
            //check for firstname and lastname
                output.append(c.toString());
                output.append(",");
        }

        output.append("]}");
        //print out for CLR
        System.out.println(output);

        return output.toString();
    }
}
