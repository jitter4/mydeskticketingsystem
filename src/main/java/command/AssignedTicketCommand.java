package command;

import command.handler.CommandHandler;

public class AssignedTicketCommand extends Command {
    public AssignedTicketCommand(CommandHandler handler) {
        super(handler);
    }

    @Override
    public void execute(String[] params) {
        if (params.length != 1) {
            System.out.println("Invalid count of args");
            return;
        }
        this.handler.assign(params[0]);
    }
}
