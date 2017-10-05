package contacts_manager;

import util.Input;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContentsTest {
//        static FileHandler filehandler = new FileHandler("data", "contacts.txt");
    public static Input input = new Input();

    public static void main(String[] args) throws IOException {



        FileHandler filehandler = new FileHandler("data", "contacts.txt");

        List<String> contacts = filehandler.readFromFile();


        displayMenu();
        addContact(contacts);
        contacts = deleteExistingContact(contacts);
        printAllContacts(contacts);
        exit(filehandler, contacts);
//
//
//        filehandler.writeToFile(contacts); // write several lines to a file
    }

    public static void printAllContacts(List<String> contacts) throws IOException {

        for (String contact : contacts) {
            System.out.println(contact);
        }
    }

    public static void displayMenu () {
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");

    }

    public static void addContact(List<String> contacts) {
//        System.out.println("Add a contact Name:");
        String addContactName = input.getString("Add a contact Name:");
//        System.out.println("Add the contacts number:");
        String addContactNumber = input.getString("Add the contacts number:");
        contacts.add(addContactName + " | " + addContactNumber);
    }

    public static void searchByName (){

    }

    public static List<String> deleteExistingContact(List<String> contacts) {
        List<String> newContactList = new ArrayList<>();
        try {
//        System.out.println("Remove a contact of your choice");
                printAllContacts(contacts);
            String deleteContact = input.getString("Remove a contact of your choice");
            for (String contact: contacts) {
                String[] contactInfo = contact.split(" | ");
                if(contactInfo[0].equals(deleteContact)){
                    continue;
                } newContactList.add(contact);
            } //Files.write(newContactList, contacts);
            return newContactList;
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        } return newContactList;
    }

    public static void exit (FileHandler fileHandler, List<String> contacts) {
       try {
           System.out.println("Goodbye, have a great day!)");
        fileHandler.writeToFile(contacts);
       } catch (IOException ioe) {
           System.out.println(ioe.getMessage());
           ioe.printStackTrace();
       }
    }
}