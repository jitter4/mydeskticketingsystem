package command.handler;

import managers.EmployeeManager;
import managers.TicketManager;
import models.employee.Employee;
import models.tickets.Ticket;
import models.tickets.TicketType;

public class CommandHandler {
    private final TicketManager ticketManager;
    private final EmployeeManager employeeManager;

    public CommandHandler(TicketManager ticketManager, EmployeeManager employeeManager) {
        this.ticketManager = ticketManager;
        this.employeeManager = employeeManager;
    }

    public void createTicket(TicketType type, String description) {
        Integer ticket = ticketManager.create(type, description);
        System.out.println(ticket);
    }

    public void status() {
        System.out.println(this.ticketManager.getTicketSystem().getOpenTicketsCount() + " - OPEN TICKETS");
        System.out.println(this.ticketManager.getTicketSystem().getAssignedTicketsCount() + " - ASSIGNED TICKETS");
        System.out.println(this.ticketManager.getTicketSystem().getVerifiedTicketsCount() + " - CLOSED TICKETS");
        System.out.println(this.ticketManager.getTicketCount() + " - TOTAL TICKETS");
    }

    public void status(Integer ticketNumber) {
        Ticket ticket = this.ticketManager.getTicket(ticketNumber);
        System.out.println(ticket);
    }

    public void assign(String employeeName) {
        Employee employee = this.employeeManager.createOrGet(employeeName);
        Ticket ticket = this.ticketManager.getTicketSystem().assignTicket(employee);
        if (ticket != null) {
            System.out.println(String.format("Ticket- %s %s", ticket.getNumber(), ticket.getAssignedTo()));
        }
    }

    public void resolveTicket(String employeeName, String comment) {
        Employee employee = this.employeeManager.createOrGet(employeeName);
        Ticket ticket = employee.performAction(comment);
        if (ticket != null)
            System.out.println(String.format("Ticket-%s resolved by %s with comment %s",
                    ticket.getNumber(), ticket.getResolvedBy(), ticket.getResolutionComment()));
    }

    public void verifyTicketResolution(String employeeName) {
        Employee employee = this.employeeManager.createOrGet(employeeName);
        Ticket ticket = employee.performAction(null);
        if (ticket != null)
            System.out.println(String.format("Ticket-%s resolution verified by supervisor %s",
                    ticket.getNumber(), ticket.getVerifiedBy()));
    }
}
