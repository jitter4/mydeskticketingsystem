package models.tickets;

import models.employee.Employee;
import models.employee.strategies.DefaultTicketAssignStrategy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class TicketSystem {

    private DefaultTicketAssignStrategy ticketAssignStrategy;

    Queue<Ticket> openTickets = new LinkedList<>();
    Queue<Ticket> resolvedTickets = new LinkedList<>();
    Queue<Ticket> verifiedTickets = new LinkedList<>();
    HashSet<Ticket> assigned = new HashSet<>();

    private Map<Integer, Ticket> tickets = new HashMap<>();

    public void setTicketAssignStrategy(DefaultTicketAssignStrategy ticketAssignStrategy) {
        this.ticketAssignStrategy = ticketAssignStrategy;
    }

    public Ticket pollOpenTicket() {
        Ticket ticket = this.openTickets.poll();
        this.assigned.add(ticket);
        return ticket;
    }

    public HashSet<Ticket> getAssigned() {
        return assigned;
    }

    public Ticket pollResolvedTicket() {
        Ticket ticket = this.resolvedTickets.poll();
        this.assigned.add(ticket);
        return ticket;
    }

    public void addToOpen(Ticket ticket) {
        this.openTickets.add(ticket);
    }

    public void addToResolved(Ticket ticket) {
        resolvedTickets.add(ticket);
    }

    public void addToVerified(Ticket ticket) {
        this.verifiedTickets.add(ticket);
    }

    public void unAssign(Ticket ticket) {
        this.assigned.remove(ticket);
    }

    public Integer getOpenTicketsCount() {
        return this.openTickets.size() + this.getAssignedTicketsCount();
    }

    public int getAssignedTicketsCount() {
        return (int) this.assigned
                .stream()
                .filter(Objects::nonNull)
                .count();
    }

    public Integer getResolvedTicketsCount() {
        return this.resolvedTickets.size();
    }

    public Integer getVerifiedTicketsCount() {
        return this.verifiedTickets.size();
    }

    public Queue<Ticket> getResolvedTickets() {
        return resolvedTickets;
    }

    public Queue<Ticket> getVerifiedTickets() {
        return verifiedTickets;
    }

    public Ticket assignTicket(Employee employee) {
        return this.ticketAssignStrategy.assign(employee);
    }
}
