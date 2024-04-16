package at.fhv.lab1.queryclient.queries;

import java.time.LocalDate;

public class GetBookingsQuery {

    private LocalDate startDate;
    private LocalDate endDate;

    public GetBookingsQuery() {

    }
    public GetBookingsQuery(LocalDate timestampStart, LocalDate timestampEnd) {
        this.startDate = timestampStart;
        this.endDate = timestampEnd;
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
        return "GetBookingsQuery{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
