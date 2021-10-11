package models.employee.strategies.factory;

import models.Role;
import models.employee.strategies.EmployeeResolveTicketStrategy;
import models.employee.strategies.ResolveTicketStrategy;
import models.employee.strategies.SupervisorResolveTicketStrategy;
import models.tickets.TicketStatus;

import java.util.HashMap;
import java.util.Map;

public class ResolveTicketStartegyFactory {

    private static final Map<TicketStatus, ResolveTicketStrategy> STRATEGIES;

    static {
        STRATEGIES = new HashMap<>();
        STRATEGIES.put(TicketStatus.CREATED, new EmployeeResolveTicketStrategy());
        STRATEGIES.put(TicketStatus.RESOLVED, new SupervisorResolveTicketStrategy());
    }

    public static ResolveTicketStrategy get(TicketStatus ticketStatus) {
        return STRATEGIES.get(ticketStatus);
    }


}
