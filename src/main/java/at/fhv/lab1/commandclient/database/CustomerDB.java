package at.fhv.lab1.commandclient.database;

import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class CustomerDB {

    private static ArrayList<Customer> customers;

    public CustomerDB() {

        customers = new ArrayList<>();
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static Customer getCustomerById(int id) {
        for(Customer c: customers) {
            if(c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public static boolean contains(Customer customer) {
        return customers.contains(customer);
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
}
