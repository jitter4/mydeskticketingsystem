package managers;

import models.employee.Employee;
import models.employee.strategies.DefaultTicketAssignStrategy;
import models.tickets.TicketSystem;

import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {

    private final TicketSystem ticketSystem;

    private final Map<String, Employee> employees = new HashMap<>();

    public EmployeeManager(TicketSystem ticketSystem) {
        this.ticketSystem = ticketSystem;
    }

    public Employee createOrGet(String name) {
        Employee employee = this.employees.get(name);
        if (employee == null)
            this.employees.put(name, employee = new Employee(name));
        return employee;
    }

}
