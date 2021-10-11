package models.tickets.strategies;

import models.tickets.Ticket;
import models.tickets.TicketSystem;

public class ChangeLanguageTicketResolutionStartegy extends AutoResolveTicketStrategy {
    public ChangeLanguageTicketResolutionStartegy(TicketSystem ticketSystem) {
        super(ticketSystem);
    }

    @Override
    public TicketResolutionResponse performAction(Ticket ticket, String comment) {
        return new TicketResolutionResponse(true, "automatic IVR call made to the\n" +
                "customer");
    }
}
