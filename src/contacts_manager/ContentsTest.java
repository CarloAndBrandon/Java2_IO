package contacts_manager;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.io.IOException;
import java.nio.file.Path;

public class ContentsTest {
    public static void main(String[] args) throws IOException{
        Path path = Paths.get("contacts_manager", "contacts.txt");{
if(!Files.exists(path)){
    Files.createFile(path);
}


            System.out.println(path);
        }
    }
}
