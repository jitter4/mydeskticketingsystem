package managers;

import factories.TicketFactory;
import models.tickets.TicketSystem;
import models.tickets.TicketType;
import models.tickets.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketManager {
    private Map<Integer, Ticket> tickets = new HashMap<>();
    private TicketFactory ticketFactory;
    private final TicketSystem ticketSystem;

    public TicketManager(TicketSystem ticketSystem) {
        this.ticketSystem = ticketSystem;
        this.ticketFactory = new TicketFactory(ticketSystem);
    }

    public Ticket getTicket(Integer ticketNumber) {
        return tickets.get(ticketNumber);
    }

    public Integer create(TicketType type, String description) {
        Ticket ticket = this.ticketFactory.create(type, description);
        this.tickets.put(ticket.getNumber(), ticket);
        return ticket.getNumber();
    }

    public TicketSystem getTicketSystem() {
        return ticketSystem;
    }

    public Integer getTicketCount() {
        return tickets.size();
    }
}
