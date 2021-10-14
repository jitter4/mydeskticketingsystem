package models.tickets.strategies;

import models.tickets.Ticket;
import models.tickets.TicketQueueSystem;

public class ChangeLanguageTicketResolutionStartegy extends AutoResolveTicketStrategy {
    public ChangeLanguageTicketResolutionStartegy(TicketQueueSystem ticketQueueSystem) {
        super(ticketQueueSystem);
    }

    @Override
    public TicketResolutionResponse performAction(Ticket ticket, String comment) {
        return new TicketResolutionResponse(true, "automatic IVR call made to the\n" +
                "customer");
    }
}
