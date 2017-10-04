package contacts_manager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContentsTest  {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        FileHandler filehandler = new FileHandler("data", "contacts.txt");

        List<String> contact = new ArrayList<>();
        contact.add("carlo | 123-123-1234");
        contact.add("brandon | 234-234-2345");

        System.out.println("ad a cobatct");
        String add = scan.nextLine();
        contact.add(add);

        filehandler.writeToFile(contact); // write several lines to a file
        printAllContacts(filehandler);

    }

    public static void printAllContacts(FileHandler fh) throws IOException {
        List<String> contacts = fh.readFromFile();

        for (String contact : contacts){
            System.out.println(contact);
        }
    }
}
