package at.fhv.lab1.commandclient.domain;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class Customer {

    private static int idCounter;
    private final int id;
    private String firstname;
    private String surname;
    private String email;
    private String address;
    private LocalDate birthdate;

    public Customer(String firstname, String surname, LocalDate birthdate, String email, String address) {
        id = idCounter++;
        this.firstname = firstname;
        this.surname = surname;
        this.birthdate = birthdate;
        this.email = email;
        this.address = address;
    }

    public Customer(int id, String firstname, String surname, LocalDate birthdate, String email, String address) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.birthdate = birthdate;
        this.email = email;
        this.address = address;
    }
    public Customer() {
        id = idCounter++;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
