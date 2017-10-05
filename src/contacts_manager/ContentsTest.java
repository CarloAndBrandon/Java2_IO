package contacts_manager;

import util.Input;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ContentsTest {
    public static Input input = new Input();

    public static void main(String[] args) throws IOException {
        greatCommandLineProgram();
    }


    public static void printAllContacts(List<String> contacts) {

        System.out.println("Name   |  Phone Number\n" + "------------------------");
        for (String contact : contacts) {
            System.out.println(contact);


        }
    }

    public static void namesOnly (List<String> contacts) {
        for (String contact : contacts) {
//            System.out.println(contact);
            String[] contName = contact.split(Pattern.quote("|"));
            System.out.println(contName[0]);
        }
    }


    public static void displayMenu() {
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");



    }




    public static void addContact(List<String> contacts) {


            String addContactName = input.getString("Add a contact Name:");
            String addContactNumber = input.getString("Add the contacts number:");
            contacts.add(addContactName + " | " + addContactNumber);

    }

    public static void searchByName(List<String> contacts) {
        String searchByName = input.getString("Search Contact name");

        for (String contact : contacts) {
            String[] contactSearch = contact.split(Pattern.quote("|"));

            if (contactSearch[0].trim().equalsIgnoreCase(searchByName)) {
                System.out.println(contact);


            }
        }

    }

    public static List<String> deleteExistingContact(List<String> contacts) {
        List<String> newContactList = new ArrayList<>();


            printAllContacts(contacts);
            String deleteContact = input.getString("Remove a contact of your choice");

            for (String contact : contacts) {
                String[] contactInfo = contact.split(" | ");

                if (contactInfo[0].equals(deleteContact)) {
                    continue;
                }
                newContactList.add(contact);
            }
        return newContactList;
    }

    public static void exit(FileHandler fileHandler, List<String> contacts) {

            System.out.println("Goodbye, have a great day!)");
            fileHandler.writeToFile(contacts);

    }

    public static void greatCommandLineProgram() {

        FileHandler filehandler = new FileHandler("data", "contacts.txt");
        List<String> contacts = filehandler.readFromFile();
        String another;

        do {


        displayMenu();
        int a = input.getInt();
        switch (a) {
            case 1:
                printAllContacts(contacts);
                System.out.println();
                break;
            case 2:
                addContact(contacts);
                System.out.println();
                printAllContacts(contacts);
                break;
            case 3:
                namesOnly(contacts);
                searchByName(contacts);
                System.out.println();
                break;
            case 4:
                contacts = deleteExistingContact(contacts);
                System.out.println();
                printAllContacts(contacts);
                break;
            case 5:
                exit(filehandler, contacts);
                System.exit(a);
                break;
            default:
                System.out.println("Sorry that not a valid input");
                break;
        }
        another = input.getString("\"Would you like to go back to the main menu?");


    }while (another.equalsIgnoreCase("y") || (another.equalsIgnoreCase("yes")));
        exit(filehandler, contacts);

    }


}
