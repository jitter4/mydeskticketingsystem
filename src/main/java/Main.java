import orchestrator.MyDeskOrchestrator;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MyDeskOrchestrator orchestrator = new MyDeskOrchestrator(args.length > 0 ? args[0] : null);
        orchestrator.execute();
    }
}
