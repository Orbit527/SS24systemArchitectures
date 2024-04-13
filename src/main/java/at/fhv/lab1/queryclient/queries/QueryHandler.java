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
import java.util.stream.Collectors;


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

        for (BookingProjected b : BookingsProjectedDB.getBookings()) {
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

    public String handleGetFreeRoomsQuery(GetFreeRoomsQuery query) {

        System.out.println(query);

        System.out.println(FreeRoomsProjectedDB.getFreeRooms());

        //TODO: filter according to timeframe and personCount

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

        return output.toString();

    }

    private boolean hasOverlap(ArrayList<Timeframe> timeframes, LocalDate newStartDate, LocalDate newEndDate) {
        for (Timeframe timeframe : timeframes) {
            if (newStartDate.isBefore(timeframe.getEndDate()) && timeframe.getStartDate().isBefore(newEndDate)) {
                return true;
            }
        }
        return false;
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

        // check if firstname is set in query
        /*
        if(!Objects.equals(query.getFirstname(), "null") && !query.getFirstname().isEmpty()) {
            ArrayList<CustomersProjected> test = CustomersProjectedDB.getCustomerByFirstname(query.getFirstname());
            System.out.println("PEOPLE WITH FIRSTNAME: " + test);
        }
         */



        //TODO: remove last colon

        for (CustomerProjected c : CustomersProjectedDB.getCustomers()) {
            //check for firstname and lastname
                output.append(c.toString());
                output.append(",");

        }

        output.append("]}");

        return output.toString();

    }
}
