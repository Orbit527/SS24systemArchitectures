package at.fhv.lab1.commandclient.database;

import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;
import at.fhv.lab1.commandclient.domain.Room;

import java.util.ArrayList;

public class BookingDB {

    private static ArrayList<Booking> bookings;

    public BookingDB() {
        bookings = new ArrayList<>();
    }

    public static ArrayList<Booking> getBookings() {
        return bookings;
    }

    public static Booking getBookingById(int id) {
        for(Booking b : bookings) {
            if(b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public static void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public static void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

}
