package at.fhv.lab1.queryclient.database;

import at.fhv.lab1.queryclient.domain.BookingsProjected;

import java.util.ArrayList;

public class BookingsProjectedDB {

    private static ArrayList<BookingsProjected> bookings;

    public BookingsProjectedDB() {
        bookings = new ArrayList<>();
    }

    public static ArrayList<BookingsProjected> getBookings() {
        return bookings;
    }

    public static void addBooking(BookingsProjected booking) {
        bookings.add(booking);
    }

    public static void removeBooking(BookingsProjected booking) {
        bookings.remove(booking);
    }

}
