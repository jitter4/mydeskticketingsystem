package models.employee.strategies;

import models.tickets.Ticket;

public class SupervisorResolveTicketStrategy implements ResolveTicketStrategy {

    @Override
    public boolean resolve(Ticket ticket, String comment) {
        ticket.verifyResolved();
        return true;
    }
}
