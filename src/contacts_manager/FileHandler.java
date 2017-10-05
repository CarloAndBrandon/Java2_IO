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


    public FileHandler(String directory, String fileName) {
        try {

            this.directory = directory;
            this.fileName = fileName;
            this.dataFile = Paths.get(this.directory, this.fileName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void createFile() {
        try {
            Path dataDirectory = Paths.get(this.directory);
            Path dataFile = Paths.get(this.directory, this.fileName);

            if (Files.notExists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        }

    public void writeToFile(List<String> contacts) {
        try {
            Files.write(dataFile, contacts);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    public List<String> readFromFile() {
        try {
            return Files.readAllLines(dataFile);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }

        return null;
    }
}