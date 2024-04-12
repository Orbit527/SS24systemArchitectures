package at.fhv.lab1.queryclient.database;

import at.fhv.lab1.queryclient.domain.CustomersProjected;

import java.util.ArrayList;
import java.util.Objects;

public class CustomersProjectedDB {

    private static ArrayList<CustomersProjected> customers;

    public CustomersProjectedDB() {
        customers = new ArrayList<>();
    }

    public static ArrayList<CustomersProjected> getCustomers() {
        return customers;
    }

    public static ArrayList<CustomersProjected> getCustomerByFirstname(String firstname) {
        ArrayList<CustomersProjected> result = new ArrayList<>();
        for(CustomersProjected c: customers) {
            if(Objects.equals(c.getFirstname(), firstname)) {
                result.add(c);
            }
        }
        return result;
    }

    public static ArrayList<CustomersProjected> getCustomerBySurname(String surname) {
        ArrayList<CustomersProjected> result = new ArrayList<>();
        for(CustomersProjected c: customers) {
            if(Objects.equals(c.getSurname(), surname)) {
                result.add(c);
            }
        }
        return result;
    }

    public static ArrayList<CustomersProjected> getCustomerByFirstAndSurname(String firstname, String surname) {
        ArrayList<CustomersProjected> result = new ArrayList<>();
        for(CustomersProjected c: customers) {
            if(Objects.equals(c.getFirstname(), firstname) && Objects.equals(c.getSurname(), surname)) {
                result.add(c);
            }
        }
        return result;
    }

    public static void addCustomer(CustomersProjected customer) {
        customers.add(customer);
    }

    public static void removeCustomer(CustomersProjected customer) {
        customers.remove(customer);
    }

}
