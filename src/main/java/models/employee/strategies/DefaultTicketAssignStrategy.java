package models.employee.strategies;

import models.employee.Employee;
import models.tickets.Ticket;
import models.tickets.TicketSystem;

public class DefaultTicketAssignStrategy {

    public final TicketSystem ticketSystem;

    public DefaultTicketAssignStrategy(TicketSystem ticketSystem) {
        this.ticketSystem = ticketSystem;
    }

    public Ticket assign(Employee employee) {
        Ticket ticket = null;
        if (employee.isSupervisor()) {
            ticket = this.ticketSystem.pollResolvedTicket();
        }
        if (ticket == null && employee.isEmployee()) {
            ticket = this.ticketSystem.pollOpenTicket();
        }
        if (ticket == null) {
            System.out.println("No tickets available");
            return null;
        }
        employee.setTicket(ticket);
        ticket.setAssignedTo(employee);
        return ticket;
    }
}
