package at.fhv.lab1.queryclient.queries;

import java.time.LocalDate;

public class GetFreeRoomsQuery {


    private LocalDate startDate;
    private LocalDate endDate;
    private int personCount;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    @Override
    public String toString() {
        return "GetFreeRoomsQuery{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", personCount=" + personCount +
                '}';
    }

}
