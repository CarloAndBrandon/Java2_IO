package contacts_manager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.io.IOException;

public class ContentsTest {
    public static void main(String[] args) throws IOException {
        String directory = "data";
        String filename = "contacts.txt";

        FileHandler contactsFile = new FileHandler (directory, filename);
        contactsFile.createFile();
    }
}
