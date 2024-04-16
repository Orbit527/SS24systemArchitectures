package at.fhv.lab1.queryclient.clientRest;

public class GetCustomersRest {
    private String firstname;
    private String surname;

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

    @Override
    public String toString() {
        return "GetCustomersRest{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
