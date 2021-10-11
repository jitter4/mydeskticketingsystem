package models.tickets.strategies;

import models.employee.Employee;
import models.tickets.Ticket;
import models.tickets.TicketSystem;

public abstract class TicketResolutionStrategy {

    protected final TicketSystem ticketSystem;

    protected TicketResolutionStrategy(TicketSystem ticketSystem) {
        this.ticketSystem = ticketSystem;
    }

    public abstract void apply(Ticket ticket);
    public abstract TicketResolutionResponse performAction(Ticket ticket, String comment);
    public abstract void resolve(Ticket ticket);

    public void verifyResolution(Ticket ticket) {
        this.ticketSystem.unAssign(ticket);
        this.ticketSystem.addToVerified(ticket);
    }


}
