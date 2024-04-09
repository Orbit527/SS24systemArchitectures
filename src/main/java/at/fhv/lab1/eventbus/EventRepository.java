package at.fhv.lab1.eventbus;

import at.fhv.lab1.eventbus.events.Event;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import org.springframework.stereotype.Component;
import java.io.*;

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

    public void getAllFromEventDatabase() {
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
    }

}