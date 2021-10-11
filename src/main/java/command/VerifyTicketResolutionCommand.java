package command;

import command.handler.CommandHandler;

public class VerifyTicketResolutionCommand extends Command {
    public VerifyTicketResolutionCommand(CommandHandler handler) {
        super(handler);
    }

    @Override
    public void execute(String[] params) {
        if (params.length != 1) {
            System.out.println("Invalid param count");
            return;
        }
        this.handler.verifyTicketResolution(params[0]);
    }
}
