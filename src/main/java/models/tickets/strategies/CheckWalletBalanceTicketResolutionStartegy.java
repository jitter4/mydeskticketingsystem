package models.tickets.strategies;

import models.tickets.Ticket;
import models.tickets.TicketQueueSystem;

public class CheckWalletBalanceTicketResolutionStartegy extends AutoResolveTicketStrategy {
    public CheckWalletBalanceTicketResolutionStartegy(TicketQueueSystem ticketQueueSystem) {
        super(ticketQueueSystem);
    }

    @Override
    public TicketResolutionResponse performAction(Ticket ticket, String comment) {
        return new TicketResolutionResponse(true, "sent automatic SMS to customer");
    }
}
