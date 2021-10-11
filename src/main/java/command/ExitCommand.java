package command;

import command.handler.CommandHandler;

public class ExitCommand extends Command {
    public ExitCommand(CommandHandler handler) {
        super(handler);
    }

    @Override
    public void execute(String[] params) {
        System.exit(0);
    }
}
