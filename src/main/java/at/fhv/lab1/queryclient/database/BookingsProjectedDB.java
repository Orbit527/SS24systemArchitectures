package at.fhv.lab1.queryclient.database;

import at.fhv.lab1.queryclient.domain.BookingProjected;

import java.util.ArrayList;
import java.util.Objects;

public class BookingsProjectedDB {

    private static ArrayList<BookingProjected> bookings;

    public BookingsProjectedDB() {
        bookings = new ArrayList<>();
    }

    public static ArrayList<BookingProjected> getBookings() {
        return bookings;
    }

    public static BookingProjected getBookingById(int id) {
        for(BookingProjected b: bookings) {
            if(Objects.equals(b.getBookingId(), id)) {
                return b;
            }
        }
        return null;
    }

    public static void addBooking(BookingProjected booking) {
        bookings.add(booking);
    }

    public static void removeBooking(BookingProjected booking) {
        bookings.remove(booking);
    }

}
