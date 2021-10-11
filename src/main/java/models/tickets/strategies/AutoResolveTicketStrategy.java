package models.tickets.strategies;

import models.employee.strategies.ResolveTicketStrategy;
import models.tickets.TicketSystem;
import models.tickets.Ticket;

public abstract class AutoResolveTicketStrategy extends TicketResolutionStrategy {

    protected AutoResolveTicketStrategy(TicketSystem ticketSystem) {
        super(ticketSystem);
    }

    @Override
    public void apply(Ticket ticket) {
        ticket.performAction(null);
    }

    public void resolve(Ticket ticket) {
        this.ticketSystem.addToVerified(ticket);
    }

//    brute force
//    1) easy - 30 min for optimised, 3 special inteers, Longest inc subs, Array to bst, Magic index binary, 2d prefix submatrix, binnary search, avg of all nodes in subtree,
//    graph topo, bfs,
//    time complexity,
//    2) brute force and correct impl
//
//
//    inveterted tree
}
