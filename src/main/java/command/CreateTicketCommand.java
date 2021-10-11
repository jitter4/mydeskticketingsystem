package command;

import command.handler.CommandHandler;
import models.tickets.TicketType;

public class CreateTicketCommand extends Command {
    public CreateTicketCommand(CommandHandler handler) {
        super(handler);
    }

    @Override
    public void execute(String[] params) {
        TicketType type = null;
        try {
            type = TicketType.valueOf(params[0].replace("-", "_").toUpperCase());
        } catch (Exception ex) {
            System.out.println("Invalid ticket type");
            return;
        }
        this.handler.createTicket(type, params.length > 1 ? params[1] : null);
    }
}
