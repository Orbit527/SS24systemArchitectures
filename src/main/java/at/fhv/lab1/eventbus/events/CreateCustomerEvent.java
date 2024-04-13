package at.fhv.lab1.eventbus.events;

import java.time.LocalDate;

public class CreateCustomerEvent {

    private String firstname;
    private String surname;
    private String email;
    private String address;
    private LocalDate birthdate;

    // Default constructor
    public CreateCustomerEvent() {
    }

    public CreateCustomerEvent(String firstname, String surname, String email, String address, LocalDate birthdate) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.birthdate = birthdate;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "{" +
                "\"event\":\"" + "CreateCustomerEvent" + "\"," +
                "\"firstname\":\"" + firstname + "\"," +
                "\"surname\":\"" + surname + "\"," +
                "\"email\":\"" + email + "\"," +
                "\"address\":\"" + address + "\"," +
                "\"birthdate\":\"" + birthdate + "\"" +
                "}";
    }

}
