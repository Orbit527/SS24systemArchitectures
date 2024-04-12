package at.fhv.lab1.queryclient.domain;


import java.time.LocalDate;

public class Timeframe {

    private LocalDate startDate;
    private LocalDate endDate;

    public Timeframe(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }



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

    @Override
    public String toString() {
        return "Timeframe{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
