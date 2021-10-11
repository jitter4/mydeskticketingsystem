package command.factory;

import command.AssignedTicketCommand;
import command.Command;
import command.CreateTicketCommand;
import command.ExitCommand;
import command.ResolveTicketCommand;
import command.StatusCommand;
import command.VerifyTicketResolutionCommand;
import command.handler.CommandHandler;
import managers.EmployeeManager;
import managers.TicketManager;
import models.employee.strategies.DefaultTicketAssignStrategy;
import models.tickets.TicketSystem;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private final Map<String, Command> commands;

    public CommandFactory() {
        this.commands = new HashMap<>();
        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.setTicketAssignStrategy(new DefaultTicketAssignStrategy(ticketSystem));
        CommandHandler commandHandler = new CommandHandler(
                new TicketManager(ticketSystem),
                new EmployeeManager(ticketSystem));
        this.commands.put("create-ticket", new CreateTicketCommand(commandHandler));
        this.commands.put("status", new StatusCommand(commandHandler));
        this.commands.put("assign-ticket", new AssignedTicketCommand(commandHandler));
        this.commands.put("resolve-ticket", new ResolveTicketCommand(commandHandler));
        this.commands.put("verify-ticket-resolution", new VerifyTicketResolutionCommand(commandHandler));
        this.commands.put("exit", new ExitCommand(commandHandler));
    }

    public Command getCommand(String command) {
        return this.commands.get(command);
    }
}
