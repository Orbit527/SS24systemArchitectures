package at.fhv.lab1.queryclient.domain;

public class BookingsProjected {

    private long timestampStart;
    private long timestampEnd;
    private String customerFirstname;
    private String customerSurname;
    private int roomNr;
    private int capacity;
    private int floor;


    public BookingsProjected() {

    }
    public BookingsProjected(long timestampStart, long timestampEnd, String customerName, String customerSurname, int roomNr, int capacity, int floor) {
        this.timestampStart = timestampStart;
        this.timestampEnd = timestampEnd;
        this.customerFirstname = customerName;
        this.customerSurname = customerSurname;
        this.roomNr = roomNr;
        this.capacity = capacity;
        this.floor = floor;
    }

    public long getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(long timestampStart) {
        this.timestampStart = timestampStart;
    }

    public long getTimestampEnd() {
        return timestampEnd;
    }

    public void setTimestampEnd(long timestampEnd) {
        this.timestampEnd = timestampEnd;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public int getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "GetBookingsProjected{" +
                "timestampStart=" + timestampStart +
                ", timestampEnd=" + timestampEnd +
                ", customerFirstname='" + customerFirstname + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", roomNr=" + roomNr +
                ", capacity=" + capacity +
                ", floor=" + floor +
                '}';
    }
}
