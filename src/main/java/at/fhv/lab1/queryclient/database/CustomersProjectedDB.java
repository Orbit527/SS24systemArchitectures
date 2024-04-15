package at.fhv.lab1.queryclient.database;

import at.fhv.lab1.queryclient.domain.CustomerProjected;

import java.util.ArrayList;
import java.util.Objects;

public class CustomersProjectedDB {

    private static ArrayList<CustomerProjected> customers;

    public CustomersProjectedDB() {
        customers = new ArrayList<>();
    }

    public static ArrayList<CustomerProjected> getCustomers() {
        return customers;
    }

    public static ArrayList<CustomerProjected> getCustomerByFirstname(String firstname) {
        ArrayList<CustomerProjected> result = new ArrayList<>();
        for(CustomerProjected c: customers) {
            if(Objects.equals(c.getFirstname(), firstname)) {
                result.add(c);
            }
        }
        return result;
    }

    public static ArrayList<CustomerProjected> getCustomerBySurname(String surname) {
        ArrayList<CustomerProjected> result = new ArrayList<>();
        for(CustomerProjected c: customers) {
            if(Objects.equals(c.getSurname(), surname)) {
                result.add(c);
            }
        }
        return result;
    }

    public static ArrayList<CustomerProjected> getCustomerByFirstAndSurname(String firstname, String surname) {
        ArrayList<CustomerProjected> result = new ArrayList<>();
        for(CustomerProjected c: customers) {
            if(Objects.equals(c.getFirstname(), firstname) && Objects.equals(c.getSurname(), surname)) {
                result.add(c);
            }
        }
        return result;
    }

    public static void addCustomer(CustomerProjected customer) {
        customers.add(customer);
    }

    public static void removeCustomer(CustomerProjected customer) {
        customers.remove(customer);
    }

    public static void clearCustomers() {
        customers.clear();
    }
}
