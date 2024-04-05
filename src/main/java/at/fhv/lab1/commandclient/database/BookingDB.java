package at.fhv.lab1.commandclient.database;

import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;

import java.util.ArrayList;

public class BookingDB {

    private ArrayList<Booking> bookings;

    public BookingDB() {
        bookings = new ArrayList<>();
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

}
