package contacts_manager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContentsTest {
//        static FileHandler filehandler = new FileHandler("data", "contacts.txt");
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {



        FileHandler filehandler = new FileHandler("data", "contacts.txt");

        List<String> contacts = filehandler.readFromFile();



//        addContact(contacts);
        deleteExistingContact(contacts);
        printAllContacts(contacts);
//        exit();
//
//
        filehandler.writeToFile(contacts); // write several lines to a file
    }

    public static void printAllContacts(List<String> contacts) throws IOException {

        for (String contact : contacts) {
            System.out.println(contact);
        }
    }
//        System.out.println("1. View contacts.");
//        System.out.println("2. Add a new contact.");
//        System.out.println("3. Search a contact by name.");
//        System.out.println("4. Delete an existing contact.");
//        System.out.println("5. Exit.");
//        System.out.println("Enter an option (1, 2, 3, 4 or 5):");

    public static void displayMenu () {

    }

    public static void addContact(List<String> contacts) {
        System.out.println("Add a contact Name:");
        String addContactName = scan.nextLine();
        System.out.println("Add the contacts number:");
        String addContactNumber = scan.nextLine();
        contacts.add(addContactName + " | " + addContactNumber);
    }

    public static void searchByName (){

    }

    public static void deleteExistingContact(List<String> contacts) {
        List<String> newContactList = new ArrayList<>();
        System.out.println("Remove a contact of your choice");
        System.out.println(contacts);
        String deleteContact = scan.nextLine();
        for (String contact: contacts) {
            String[] contactInfo = contact.split("|");
            if(contactInfo[0].equals(deleteContact)){
                continue;
            } newContactList.add(contact);

        } Files.write(newContactList, contacts);
    }

    public static void exit () {
        System.out.println("Goodbye, have a great day!)");
    }
}