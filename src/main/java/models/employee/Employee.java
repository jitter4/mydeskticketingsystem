package models.employee;

import models.Role;
import models.employee.strategies.ResolveTicketStrategy;
import models.employee.strategies.factory.ResolveTicketStartegyFactory;
import models.tickets.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {
    private String name;
    private List<Role> roles;
    private Ticket ticket;

    public Employee(String name) {
        this.name = name;
        this.roles = new ArrayList<>(Arrays.asList(Role.EMPLOYEE, Role.SUPERVISOR));
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket performAction(String comment) {
        Ticket result = this.ticket;
        if (this.ticket == null) {
            System.out.println("No ticket assigned");
            return null;
        }
        ResolveTicketStrategy resolveTicketStrategy = ResolveTicketStartegyFactory.get(this.ticket.getTicketStatus());
        if (resolveTicketStrategy.resolve(this.ticket, comment))
            this.ticket = null;
        return result;
    }

    public String getName() {
        return name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public boolean isSupervisor() {
        return this.roles.contains(Role.SUPERVISOR);
    }

    public boolean isEmployee() {
        return this.roles.contains(Role.EMPLOYEE);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
