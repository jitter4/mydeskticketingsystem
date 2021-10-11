package command;

import command.handler.CommandHandler;

public class ResolveTicketCommand extends Command {
    public ResolveTicketCommand(CommandHandler handler) {
        super(handler);
    }

    @Override
    public void execute(String[] params) {
        if (params.length < 2) {
            System.out.println("Invalid arg count");
            return;
        }

        StringBuilder comment = new StringBuilder();
        for (String param : params)
            comment.append(param).append(' ');

        this.handler.resolveTicket(params[0], comment.toString());
    }
}
