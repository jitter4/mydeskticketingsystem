package readers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileInputReader extends InputReader {
    public FileInputReader(String fileName) throws FileNotFoundException {
        super(new BufferedReader(new FileReader(fileName)));
    }
}
