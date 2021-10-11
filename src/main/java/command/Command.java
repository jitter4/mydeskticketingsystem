package command;

import command.handler.CommandHandler;

public abstract class Command {

    protected final CommandHandler handler;
    protected Command(CommandHandler handler) {
        this.handler = handler;
    }

    public abstract void execute(String[] params);
}
