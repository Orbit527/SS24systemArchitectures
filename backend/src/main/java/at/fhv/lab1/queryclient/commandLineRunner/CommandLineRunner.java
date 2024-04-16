package at.fhv.lab1.queryclient.commandLineRunner;

import at.fhv.lab1.commandclient.domain.BookingRest;
import at.fhv.lab1.commandclient.domain.CancelBookingRest;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;
import at.fhv.lab1.commandclient.rest.CommandClientRestController;
import at.fhv.lab1.queryclient.clientRest.ClientRestController;
import at.fhv.lab1.queryclient.clientRest.GetBookingsRest;
import at.fhv.lab1.queryclient.clientRest.GetCustomersRest;
import at.fhv.lab1.queryclient.clientRest.GetFreeRoomsRest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {

        ClientRestController c = new ClientRestController();
        boolean running = true;

        while (running) {
            System.out.println("Enter a command:");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            if (line.startsWith("getBookings")) {
                String startDate = line.split(" ")[1];
                String endDate = line.split(" ")[2];

                GetBookingsRest getBookingsRest = new GetBookingsRest();
                getBookingsRest.setStartDate(LocalDate.parse(startDate));
                getBookingsRest.setEndDate(LocalDate.parse(endDate));

                c.getBookings(getBookingsRest);
            } else if (line.startsWith("getFreeRooms")) {
                String startDate = line.split(" ")[1];
                String endDate = line.split(" ")[2];
                String personCount = line.split(" ")[3];

                GetFreeRoomsRest getFreeRoomsRest = new GetFreeRoomsRest();
                getFreeRoomsRest.setStartDate(LocalDate.parse(startDate));
                getFreeRoomsRest.setEndDate(LocalDate.parse(endDate));
                getFreeRoomsRest.setPersonCount(Integer.parseInt(personCount));

                c.getFreeRooms(getFreeRoomsRest);

            } else if (line.startsWith("getCustomers")) {
                String firstname = line.split(" ")[1];
                String surname = line.split(" ")[2];

                GetCustomersRest getCustomersRest = new GetCustomersRest();

                getCustomersRest.setFirstname(firstname);
                getCustomersRest.setSurname(surname);

                c.getCustomers(getCustomersRest);


            } else if (line.startsWith("readOutAllEvents")) {
                c.readoutAllEvents();
            } else if (line.startsWith("restoreDatabase")) {
                c.restoreDatabase();
            } else if (line.startsWith("clearDatabase")) {
                c.clearDatabase();
            }

            System.out.println(line);
        }
    }
}
