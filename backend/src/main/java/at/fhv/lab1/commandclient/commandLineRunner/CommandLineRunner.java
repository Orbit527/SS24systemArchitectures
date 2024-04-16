package at.fhv.lab1.commandclient.commandLineRunner;

import at.fhv.lab1.commandclient.domain.BookingRest;
import at.fhv.lab1.commandclient.domain.CancelBookingRest;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;
import at.fhv.lab1.commandclient.rest.CommandClientRestController;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        CommandClientRestController c = new CommandClientRestController();
        boolean running = true;

        while (running) {
            System.out.println("Enter a command:");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            if (line.startsWith("createBooking")) {
                String customerID = line.split(" ")[1];
                String roomId = line.split(" ")[2];
                String startDate = line.split(" ")[3];
                String endDate = line.split(" ")[4];

                BookingRest bookingRest = new BookingRest();
                bookingRest.setCustomerID(Integer.parseInt(customerID));
                bookingRest.setRoomID(Integer.parseInt(roomId));
                bookingRest.setStartDate(startDate);
                bookingRest.setEndDate(endDate);

                c.addBooking(bookingRest);
            } else if (line.startsWith("cancelBooking")) {
                String id = line.split(" ")[1];

                CancelBookingRest cancelBookingRest = new CancelBookingRest();
                cancelBookingRest.setId(Integer.parseInt(id));

                c.cancelBooking(cancelBookingRest);
            } else if (line.startsWith("createCustomer")) {
                String firstname = line.split(" ")[1];
                String surname = line.split(" ")[2];
                String birthdate = line.split(" ")[3];
                String email = line.split(" ")[4];
                String address = line.split(" ")[5];

                Customer customer = new Customer();
                customer.setFirstname(firstname);
                customer.setSurname(surname);
                customer.setBirthdate(LocalDate.parse(birthdate));
                customer.setEmail(email);
                customer.setAddress(address);

                c.createCustomer(customer);
            } else if (line.startsWith("createRoom")) {
                String roomNr = line.split(" ")[1];
                String floor = line.split(" ")[2];
                String capacity = line.split(" ")[3];

                Room room = new Room();
                room.setRoomNr(Integer.parseInt(roomNr));
                room.setFloor(Integer.parseInt(floor));
                room.setCapacity(Integer.parseInt(capacity));

                c.addRoom(room);
            }
        }
    }
}
