package models.tickets.strategies;

public class TicketResolutionResponse {

    final boolean isResolved;
    final String comment;

    public TicketResolutionResponse(boolean isResolved, String comment) {
        this.isResolved = isResolved;
        this.comment = comment;
    }


    public boolean isResolved() {
        return isResolved;
    }

    public String getComment() {
        return comment;
    }
}
