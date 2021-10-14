package models.employee.strategies;

import models.employee.Employee;
import models.tickets.Ticket;
import models.tickets.TicketQueueSystem;

public class DefaultTicketAssignStrategy {

    public final TicketQueueSystem ticketQueueSystem;

    public DefaultTicketAssignStrategy(TicketQueueSystem ticketQueueSystem) {
        this.ticketQueueSystem = ticketQueueSystem;
    }

    public Ticket assign(Employee employee) {
        Ticket ticket = null;
        if (employee.isSupervisor()) {
            ticket = this.ticketQueueSystem.pollResolvedTicket();
        }
        if (ticket == null && employee.isEmployee()) {
            ticket = this.ticketQueueSystem.pollOpenTicket();
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
