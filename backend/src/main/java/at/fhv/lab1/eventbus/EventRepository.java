package at.fhv.lab1.eventbus;
import at.fhv.lab1.commandclient.domain.*;
import at.fhv.lab1.eventbus.events.*;
import org.json.JSONObject;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import java.io.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventRepository {

    private final List<Event> events = new ArrayList<>();

    public void processEvent(Event event) {
        // store events in log/DB
        writeToEventDatabase(event.toString());
        // TODO: notify subscribed read repositories
        System.out.println("Processing Event");
    }

    public void processEvent(RoomBookedEvent event) {
        // store events in log/DB
        // TODO: Change toString in RoomBookedEvent to put out correct JSON
        writeToEventDatabase(event.toString());
        // TODO: notify subscribed read repositories
        System.out.println("Processing Event");
    }

    public void processEvent(CancelBookingEvent event) {
        // store events in log/DB
        writeToEventDatabase(event.toString());
        // TODO: notify subscribed read repositories
        System.out.println("Processing Event");
    }

    public void processEvent(CreateCustomerEvent event) {
        // store events in log/DB
        writeToEventDatabase(event.toString());
        // TODO: notify subscribed read repositories
        System.out.println("Processing Event");
    }

    public void processEvent(CreateRoomEvent event) {
        // store events in log/DB
        writeToEventDatabase(event.toString());
        // TODO: notify subscribed read repositories
        System.out.println("Processing Event");
    }

    public void writeToEventDatabase(String event) {
        String filePath = "src/main/java/at/fhv/lab1/eventbus/database/Events.txt";

        try (FileWriter myWriter = new FileWriter(filePath, true)) {
            myWriter.write(event);
            myWriter.write("\n");
            System.out.println("Successfully wrote to the file: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + filePath);
            e.printStackTrace();
        }
    }

    public void restoreThroughEventDatabase() {
        String filePath = "src/main/java/at/fhv/lab1/eventbus/database/Events.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            EventPublisher eventPublisher = new EventPublisher();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                JSONObject jsonObject = new JSONObject(line);

                if ("CancelBookingEvent".equals(jsonObject.get("event"))) {
                    CancelBookingEvent cancelBookingEvent = new CancelBookingEvent(jsonObject.getInt("id"));
                    eventPublisher.publishEvent(cancelBookingEvent);
                    System.out.println("CancelBookingEvent Triggered");
                }
                if ("CreateCustomerEvent".equals(jsonObject.get("event"))) {
                    String birthdayString = (String)jsonObject.get("birthdate");
                    LocalDate birthday = LocalDate.parse(birthdayString);
                    CreateCustomerEvent createCustomerEvent = new CreateCustomerEvent((String)jsonObject.get("firstname"), (String)jsonObject.get("surname"), (String)jsonObject.get("email"), (String)jsonObject.get("address"), birthday);
                    eventPublisher.publishEvent(createCustomerEvent);
                }
                if ("CreateRoomEvent".equals(jsonObject.get("event"))) {
                    CreateRoomEvent createRoomEvent = new CreateRoomEvent(jsonObject.getInt("roomId"), jsonObject.getInt("roomNr"), jsonObject.getInt("floor"), jsonObject.getInt("capacity"));
                    eventPublisher.publishEvent(createRoomEvent);
                    System.out.println("CreateRoomEvent Triggered");
                }
                if ("Event".equals(jsonObject.get("event"))) {
                    //TODO: Is this even ever called?
                    System.out.println("Event Triggered");
                }
                if ("RoomBookedEvent".equals(jsonObject.get("event"))) {
                    JSONObject customerJson = jsonObject.getJSONObject("booking").getJSONObject("customer");
                    JSONObject roomJson = jsonObject.getJSONObject("booking").getJSONObject("room");
                    JSONObject bookingJson = jsonObject.getJSONObject("booking");

                    System.out.println("MAKING THEM CLASSES");
                    Customer customer = new Customer(customerJson.getInt("id"), customerJson.getString("firstname"), customerJson.getString("surname"), LocalDate.parse(customerJson.getString("birthdate")), customerJson.getString("email"), customerJson.getString("address"));
                    Room room = new Room(roomJson.getInt("id"), roomJson.getInt("roomNr"), roomJson.getInt("floor"), roomJson.getInt("capacity"));
                    Booking booking = new Booking(bookingJson.getInt("id"), customer, room, LocalDate.parse(bookingJson.getString("startDate")), LocalDate.parse(bookingJson.getString("endDate")));
                    RoomBookedEvent roomBookedEvent = new RoomBookedEvent(booking, customer, room, LocalDate.parse(bookingJson.getString("startDate")), LocalDate.parse(bookingJson.getString("endDate")));
                    eventPublisher.publishEvent(roomBookedEvent);
                    System.out.println("RoomBookedEvent Triggered");
                }

            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public String getAllFromEventDatabase() {
        String filePath = "src/main/java/at/fhv/lab1/eventbus/database/Events.txt";
        StringBuilder fileContent = new StringBuilder();

        try (FileReader fileReader = new FileReader(filePath)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                fileContent.append((char) character);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + filePath);
            e.printStackTrace();
        }

        return fileContent.toString();
    }

}