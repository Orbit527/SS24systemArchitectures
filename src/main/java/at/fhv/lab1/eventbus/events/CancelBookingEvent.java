package at.fhv.lab1.eventbus.events;

public class CancelBookingEvent {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CancelBookingEvent{" +
                "id=" + id +
                '}';
    }
}
