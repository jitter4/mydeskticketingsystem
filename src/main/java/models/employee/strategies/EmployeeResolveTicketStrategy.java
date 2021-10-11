package models.employee.strategies;

import models.tickets.Ticket;

public class EmployeeResolveTicketStrategy implements ResolveTicketStrategy {

    @Override
    public boolean resolve(Ticket ticket, String comment) {
        return ticket.performAction(comment);
    }
}
