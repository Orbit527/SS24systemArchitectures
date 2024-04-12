package at.fhv.lab1.queryclient.queries;

import at.fhv.lab1.queryclient.database.BookingsProjectedDB;
import at.fhv.lab1.queryclient.database.CustomersProjectedDB;
import at.fhv.lab1.queryclient.database.FreeRoomsProjectedDB;
import at.fhv.lab1.queryclient.domain.BookingsProjected;
import at.fhv.lab1.queryclient.domain.CustomersProjected;


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

    public String handleGetFreeRoomsQuery(GetFreeRoomsQuery query) {

        System.out.println(query);

        System.out.println(FreeRoomsProjectedDB.getFreeRooms());


        StringBuilder output = new StringBuilder();
        output.append("{\"freeRooms\": [");

        /*
        for (BookingsProjected b : BookingsProjectedDB.getBookings()) {
            if(b.getStartDate().isBefore(query.getEndDate()) && b.getEndDate().isAfter(query.getStartDate())) {
                output.append(b.toString());
                output.append(",");
            }
        }

         */



        output.append("]}");

        return output.toString();

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

        for (CustomersProjected c : CustomersProjectedDB.getCustomers()) {
            //check for firstname and lastname
                output.append(c.toString());
                output.append(",");

        }

        output.append("]}");

        return output.toString();


    }



}
