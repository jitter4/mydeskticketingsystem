package readers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader extends InputReader {
    public ConsoleReader() {
        super(new BufferedReader(new InputStreamReader(System.in)));
    }
}
