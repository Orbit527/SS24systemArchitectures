package at.fhv.lab1.queryclient.clientRest;

import at.fhv.lab1.queryclient.database.BookingsProjectedDB;
import at.fhv.lab1.queryclient.database.CustomersProjectedDB;
import at.fhv.lab1.queryclient.database.FreeRoomsProjectedDB;
import at.fhv.lab1.queryclient.queries.GetBookingsQuery;
import at.fhv.lab1.queryclient.queries.GetCustomersQuery;
import at.fhv.lab1.queryclient.queries.GetFreeRoomsQuery;
import at.fhv.lab1.queryclient.queries.QueryHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


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

    @GetMapping("/readoutallevents")
    public String readoutAllEvents() {
        String url = "http://localhost:8080/readoutallevents";
        StringBuilder response = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Response: " + response.toString());
            } else {
                System.out.println("GET request failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while sending the GET request: " + e.getMessage());
            e.printStackTrace();
        }
        return response.toString();
    }

    @GetMapping("/restoredatabase")
    public String restoreDatabase() {
        try {
            URL url = new URL("http://localhost:8080/restoredatabase");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @GetMapping("/cleardatabase")
    public String clearDatabase() {
        CustomersProjectedDB.clearCustomers();
        FreeRoomsProjectedDB.removeFreeRooms();
        BookingsProjectedDB.removeBookings();
        return "ok";
    }

}
