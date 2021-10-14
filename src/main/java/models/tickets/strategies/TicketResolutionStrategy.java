package models.tickets.strategies;

import models.tickets.Ticket;
import models.tickets.TicketQueueSystem;

public abstract class TicketResolutionStrategy {

    protected final TicketQueueSystem ticketQueueSystem;

    protected TicketResolutionStrategy(TicketQueueSystem ticketQueueSystem) {
        this.ticketQueueSystem = ticketQueueSystem;
    }

    public abstract void apply(Ticket ticket);
    public abstract TicketResolutionResponse performAction(Ticket ticket, String comment);
    public abstract void resolve(Ticket ticket);

    public void verifyResolution(Ticket ticket) {
        this.ticketQueueSystem.unAssign(ticket);
    }


}
