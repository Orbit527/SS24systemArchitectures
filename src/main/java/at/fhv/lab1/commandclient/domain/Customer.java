package at.fhv.lab1.commandclient.domain;

public class Customer {

    private static int idCounter;
    private final int id;
    private String firstname;
    private String surname;
    private String email;
    private String address;

    public Customer(String firstname, String surname, String email, String address) {
        //TODO: chang id to UUID
        id = idCounter++;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
