package at.fhv.lab1.queryclient.domain;

import java.time.LocalDate;

public class CustomersProjected {

    private String firstname;
    private String surname;
    private String email;
    private String address;
    private LocalDate birthdate;

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
                "\"firstname\":\"" + firstname + "\"" +
                ", \"surname\":\"" + surname + "\"" +
                ", \"email\":\"" + email + "\"" +
                ", \"address\":\"" + address + "\"" +
                ", \"birthdate\":\"" + birthdate + "\"" +
                '}';
    }
}
