package models.tickets.strategies;

import models.tickets.Ticket;
import models.tickets.TicketQueueSystem;

public class DefaultResolveTicketStrategy extends TicketResolutionStrategy {
    public DefaultResolveTicketStrategy(TicketQueueSystem ticketQueueSystem) {
        super(ticketQueueSystem);
    }

    @Override
    public void apply(Ticket ticket) {
        this.ticketQueueSystem.addToOpen(ticket);
    }

    @Override
    public TicketResolutionResponse performAction(Ticket ticket, String comment) {
        return new TicketResolutionResponse(true, comment);
    }

    @Override
    public void resolve(Ticket ticket) {
        this.ticketQueueSystem.unAssign(ticket);
        this.ticketQueueSystem.addToResolved(ticket);
    }
}
