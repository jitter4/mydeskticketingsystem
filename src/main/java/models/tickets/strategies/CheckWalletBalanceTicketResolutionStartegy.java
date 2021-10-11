package models.tickets.strategies;

import models.tickets.Ticket;
import models.tickets.TicketSystem;

public class CheckWalletBalanceTicketResolutionStartegy extends AutoResolveTicketStrategy {
    public CheckWalletBalanceTicketResolutionStartegy(TicketSystem ticketSystem) {
        super(ticketSystem);
    }

    @Override
    public TicketResolutionResponse performAction(Ticket ticket, String comment) {
        return new TicketResolutionResponse(true, "sent automatic SMS to customer");
    }
}
