package command;

import command.handler.CommandHandler;
import utils.StringUtils;

public class StatusCommand extends Command {
    public StatusCommand(CommandHandler handler) {
        super(handler);
    }

    @Override
    public void execute(String[] params) {
        if (params.length == 0) {
            this.handler.status();
        } else if (params.length == 1) {
            this.handler.status(StringUtils.toInteger(params[0]));
        } else {
            System.out.println("Invalid count of args");
        }
    }
}
