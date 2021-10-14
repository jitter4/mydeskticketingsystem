package models.tickets.strategies;

import models.tickets.Ticket;
import models.tickets.TicketQueueSystem;

public abstract class AutoResolveTicketStrategy extends TicketResolutionStrategy {

    protected AutoResolveTicketStrategy(TicketQueueSystem ticketQueueSystem) {
        super(ticketQueueSystem);
    }

    @Override
    public void apply(Ticket ticket) {
        ticket.performAction(null);
    }

    public void resolve(Ticket ticket) {
    }
}
