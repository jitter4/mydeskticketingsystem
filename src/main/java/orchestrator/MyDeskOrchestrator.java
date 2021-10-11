package orchestrator;

import command.Command;
import command.factory.CommandFactory;
import readers.ConsoleReader;
import readers.FileInputReader;
import readers.InputReader;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class MyDeskOrchestrator {
    private final InputReader inputReader;
    private final CommandFactory commandFactory;

    public MyDeskOrchestrator(String fileName) throws FileNotFoundException {
        this.inputReader = fileName != null
                ? new FileInputReader(fileName)
                : new ConsoleReader();
        this.commandFactory = new CommandFactory();
    }

    public void execute() {
        Iterator<String> iterator = this.inputReader.iterator();
        while (iterator.hasNext()) {
            String[] input = iterator.next().split("\\s");
            Command command = this.commandFactory.getCommand(input[0]);
            if (command != null)
                command.execute(this.getParams(input));
        }
    }

    private String[] getParams(String[] input) {
        String[] params = new String[input.length - 1];
        for (int i = 1; i < input.length; i++)
            params[i-1] = input[i];
        return params;
    }
}
