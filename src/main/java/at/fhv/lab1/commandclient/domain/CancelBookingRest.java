package at.fhv.lab1.commandclient.domain;

public class CancelBookingRest {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CancelBookingRest{" +
                "id=" + id +
                '}';
    }
}
