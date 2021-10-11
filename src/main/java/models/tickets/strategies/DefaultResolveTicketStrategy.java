package models.tickets.strategies;

import models.tickets.Ticket;
import models.tickets.TicketSystem;

public class DefaultResolveTicketStrategy extends TicketResolutionStrategy {
    public DefaultResolveTicketStrategy(TicketSystem ticketSystem) {
        super(ticketSystem);
    }

    @Override
    public void apply(Ticket ticket) {
        this.ticketSystem.addToOpen(ticket);
    }

    @Override
    public TicketResolutionResponse performAction(Ticket ticket, String comment) {
        return new TicketResolutionResponse(true, comment);
    }

    @Override
    public void resolve(Ticket ticket) {
        this.ticketSystem.unAssign(ticket);
        this.ticketSystem.addToResolved(ticket);
    }
}
