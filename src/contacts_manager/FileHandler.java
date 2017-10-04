package contacts_manager;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;

public class FileHandler {
    private String directory;
    private String fileName;

    public FileHandler(String directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;

    }

    public void createFile() throws IOException {
        Path dataDirectory = Paths.get(this.directory);
        Path dataFile = Paths.get(this.directory, this.fileName);
        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }
        if (!Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

    }

//   public void writeToFile() {
//        Files.write(Path dataFile, contacts, APPEND);
//    }
//
//    public void readToFile () {
//        List<String> contactsRead = Files.readAllLines(Path dataFile);
//    }
}
