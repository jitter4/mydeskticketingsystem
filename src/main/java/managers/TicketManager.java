package managers;

import factories.TicketFactory;
import models.tickets.TicketQueueSystem;
import models.tickets.TicketType;
import models.tickets.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketManager {
    private final Map<Integer, Ticket> tickets = new HashMap<>();
    private final TicketFactory ticketFactory;
    private final TicketQueueSystem ticketQueueSystem;

    public TicketManager(TicketQueueSystem ticketQueueSystem) {
        this.ticketQueueSystem = ticketQueueSystem;
        this.ticketFactory = new TicketFactory(ticketQueueSystem);
    }

    public Ticket getTicket(Integer ticketNumber) {
        return tickets.get(ticketNumber);
    }

    public Integer create(TicketType type, String description) {
        Ticket ticket = this.ticketFactory.create(type, description);
        this.tickets.put(ticket.getNumber(), ticket);
        return ticket.getNumber();
    }

    public TicketQueueSystem getTicketSystem() {
        return ticketQueueSystem;
    }

    public Integer getTicketCount() {
        return tickets.size();
    }

    public Integer getVerifiedTicketsCount() {
        return this.getTicketCount()
                - (this.ticketQueueSystem.getOpenTicketsCount() + this.ticketQueueSystem.getResolvedTicketsCount());
    }
}
