package at.fhv.lab1.eventbus;

import at.fhv.lab1.eventbus.events.*;
import org.springframework.stereotype.Component;
import java.io.*;

import java.sql.SQLOutput;
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
        writeToEventDatabase(event.toString());

        // Testing Shenanigans
        getAllFromEventDatabase();

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
        System.out.println("EVENT LOG");
        String filePath = "src/main/java/at/fhv/lab1/eventbus/database/Events.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + filePath);
            e.printStackTrace();
        }
        System.out.println("EVENT LOG ENDE");
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