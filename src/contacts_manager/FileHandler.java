package contacts_manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileHandler {
    private String directory;
    private String fileName;
    private Path dataFile;


    public FileHandler(String directory, String fileName) throws IOException {
        this.directory = directory;
        this.fileName = fileName;
        this.dataFile = Paths.get(this.directory, this.fileName);
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
    public void writeToFile(List<String> contacts) throws IOException {
        Files.write( dataFile, contacts, StandardOpenOption.APPEND);
    }

    public List<String> readFromFile() throws IOException {
        return Files.readAllLines(dataFile);
    }
}