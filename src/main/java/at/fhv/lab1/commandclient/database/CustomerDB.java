package at.fhv.lab1.commandclient.database;

import at.fhv.lab1.commandclient.domain.Booking;
import at.fhv.lab1.commandclient.domain.Customer;

import java.util.ArrayList;

public class CustomerDB {

    private static ArrayList<Customer> customers;

    public CustomerDB() {

        customers = new ArrayList<>();

        customers.add(new Customer("Max", "Mustermann", "max.mustermann@max.com", "Straße 123"));
        customers.add(new Customer("Eva", "Müller", "eva.mueller@123.com", "Coole Adresse 52"));
        customers.add(new Customer("Hans", "Franz", "hans.franz@mail.com", "Bach 8234"));

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

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
}
