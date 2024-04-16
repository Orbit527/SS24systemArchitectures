package at.fhv.lab1.commandclient.commands;

public class CancelBookingCommand {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CancelBookingCommand{" +
                "id=" + id +
                '}';
    }
}
