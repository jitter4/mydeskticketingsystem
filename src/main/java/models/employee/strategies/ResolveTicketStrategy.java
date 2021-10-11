package models.employee.strategies;

import models.employee.Employee;
import models.tickets.Ticket;

public interface ResolveTicketStrategy {

    boolean resolve(Ticket ticket, String comment);
}
