package at.fhv.lab1.queryclient.database;

import at.fhv.lab1.queryclient.domain.CustomersProjected;

import java.util.ArrayList;

public class CustomersProjectedDB {

    private static ArrayList<CustomersProjected> customers;

    public CustomersProjectedDB() {
        customers = new ArrayList<>();
    }

    public static ArrayList<CustomersProjected> getCustomers() {
        return customers;
    }

    public static void addCustomer(CustomersProjected customer) {
        customers.add(customer);
    }

    public static void removeCustomer(CustomersProjected customer) {
        customers.remove(customer);
    }

}
