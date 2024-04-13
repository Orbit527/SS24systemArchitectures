package at.fhv.lab1.eventbus.events;

public class CancelBookingEvent {

    private int id;

    // Default constructor
    public CancelBookingEvent() {
    }

    public CancelBookingEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "\"event\":\"" + "CancelBookingEvent" + "\"," +
                "\"id\":" + id +
                "}";
    }

}
