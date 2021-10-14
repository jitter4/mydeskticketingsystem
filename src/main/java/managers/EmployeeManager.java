package managers;

import models.employee.Employee;
import models.tickets.TicketQueueSystem;

import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {

    private final TicketQueueSystem ticketQueueSystem;

    private final Map<String, Employee> employees = new HashMap<>();

    public EmployeeManager(TicketQueueSystem ticketQueueSystem) {
        this.ticketQueueSystem = ticketQueueSystem;
    }

    public Employee createOrGet(String name) {
        Employee employee = this.employees.get(name);
        if (employee == null)
            this.employees.put(name, employee = new Employee(name));
        return employee;
    }

}
