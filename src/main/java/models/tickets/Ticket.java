package models.tickets;

import models.employee.Employee;
import models.tickets.strategies.TicketResolutionResponse;
import models.tickets.strategies.TicketResolutionStrategy;

public class Ticket {
    protected Integer number;
    protected TicketType type;
    protected String description;
    protected String resolutionComment;
    protected TicketStatus ticketStatus;
    protected Employee assignedTo;
    protected Employee resolvedBy;
    protected Employee verifiedBy;
    private TicketResolutionStrategy resolveTicketStrategy;

    public Ticket(Integer number, TicketType type, String description,
                  TicketResolutionStrategy resolveTicketStrategy) {
        this.number = number;
        this.type = type;
        this.description = description;
        this.ticketStatus = TicketStatus.CREATED;
        this.resolveTicketStrategy = resolveTicketStrategy;
        this.resolveTicketStrategy.apply(this);
    }

    public void resolve(Employee resolvedBy, String resolutionComment) {
        this.resolvedBy = resolvedBy;
        this.resolutionComment = resolutionComment;
        this.assignedTo = null;
        this.ticketStatus = TicketStatus.RESOLVED;
        this.resolveTicketStrategy.resolve(this);
    }

    public void verifyResolved() {
        this.verifiedBy = assignedTo;
        this.assignedTo = null;
        this.ticketStatus = TicketStatus.VERIFIED;
        this.resolveTicketStrategy.verifyResolution(this);
    }

    public boolean performAction(String comment) {
        TicketResolutionResponse resolutionResponse = this.resolveTicketStrategy.performAction(this, comment);
        if (resolutionResponse.isResolved()) {
            this.resolve(this.assignedTo, resolutionResponse.getComment());
            return true;
        }
        return false;
    }

    public void setAssignedTo(Employee assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Employee getAssignedTo() {
        return assignedTo;
    }

    public Integer getNumber() {
        return number;
    }

    public TicketType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public Employee getResolvedBy() {
        return resolvedBy;
    }

    public Employee getVerifiedBy() {
        return verifiedBy;
    }

    public String getResolutionComment() {
        return resolutionComment;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "number=" + number +
                ", resolutionComment='" + resolutionComment + '\'' +
                ", ticketStatus=" + ticketStatus +
                ", resolvedBy=" + resolvedBy +
                ", verifiedBy=" + verifiedBy +
                ", description=" + description +
                '}';
    }
}
