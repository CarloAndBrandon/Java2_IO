package contacts_manager;

import util.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ContactsManagerApp {
    public static Input input = new Input();

    public static void main(String[] args) throws IOException {
//        createContactsApplication();
        greatCommandLineProgramcreatedByTheBestTwoProgrammersInCodeupBitchesMotherfuckerSuckMyDickFuckYouRepresent210();


    }















    public static void displayMenu() {
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("\nEnter an option (1, 2, 3, 4 or 5):");

    }

    public static void printAllContacts(List<String> s) {

        System.out.println("Name   |  Phone Number\n" + "------------------------");
        for (String contact : s) {
            String[] contactParts = contact.split("[|]");
            System.out.println(contactParts[0] + " | " + phoneFormatter(contactParts[1].trim()));


        }
    }

    public static void addContact(List<String> contacts) {
        String addContactName = input.getString("Add a contact Name:");
        try {
            Integer.parseInt(addContactName);
            System.out.println("The name can not be a number. Please enter a valid name");
            addContact(contacts);
            return;
        } catch (NumberFormatException nfe) {

        }
        String addContactNumber = input.getPhoneNumber("Add the contact number:");
        contacts.add(addContactName + " | " + addContactNumber);
    }



    public static String searchByName(List<String> contacts) {
        namesOnly(contacts);
        String searchByName = input.getString("\nSearch Contact name:");

        for (String contact : contacts) {
            String[] contactSearch = contact.split(Pattern.quote("|"));

            if (contactSearch[0].trim().equalsIgnoreCase(searchByName)) {
                return "\n" + contact;
            }
        }
        System.out.println("\nSorry that is not a valid input, please try again\n");
        return "";
    }




    public static void namesOnly(List<String> contacts) {
        for (String contact : contacts) {
            String[] contName = contact.split(Pattern.quote("|"));
            System.out.println(contName[0]);
        }
    }


    public static List<String> deleteExistingContact(List<String> contacts) {
        List<String> newContactList = new ArrayList<>();

        printAllContacts(contacts);
        String deleteContact = input.getString("\nRemove a contact of your choice");
        int index = -1;

        for (int i = 0; i < contacts.size(); i++) {
            String name = contacts.get(i).split(" | ")[0];
            if (name.equals(deleteContact)) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            for (String contact : contacts) {
                String[] contactInfo = contact.split(" | ");

                if (contactInfo[0].equals(deleteContact)) {
                    continue;
                }
                newContactList.add(contact);
            }
            return newContactList;
        } else {
            System.out.println("The name you inputted does not match a name on the list!");
            return contacts;
        }

    }

    public static void exit(FileHandler fileHandler, List<String> contacts) {

        System.out.println("Goodbye, have a great day!)");
        fileHandler.writeToFile(contacts);

    }


    public static String phoneFormatter(String phoneNumber){
        String areaCode = phoneNumber.substring(0,3);
        String threeNumbersAfterAreaCode = phoneNumber.substring(3,6);
        String lastFourNumbers = phoneNumber.substring(6);
        return "(" + areaCode + ")" + threeNumbersAfterAreaCode + "-" + lastFourNumbers;
    }



    public static void  greatCommandLineProgramcreatedByTheBestTwoProgrammersInCodeupBitchesMotherfuckerSuckMyDickFuckYouRepresent210() {

        FileHandler filehandler = new FileHandler("data", "contacts.txt");
        List<String> contacts = filehandler.readFromFile();
        String another;

        do {

            displayMenu();
            int a = input.getInt();
            switch (a) {
                case 1:
                    System.out.println();
                    printAllContacts(contacts);
                    System.out.println();

                    break;
                case 2:
                    System.out.println();
                    addContact(contacts);
                    System.out.println();
                    printAllContacts(contacts);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println(searchByName(contacts));
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    contacts = deleteExistingContact(contacts);
                    System.out.println();
                    printAllContacts(contacts);
                    break;
                case 5:
                    System.out.println();
                    exit(filehandler, contacts);
                    System.exit(a);
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("Sorry that not a valid input");
                    break;
            }
            another = input.getString("Would you like to go back to the main menu?");

            while (!another.equalsIgnoreCase("n") && !another.equalsIgnoreCase("no") &&
                    !another.equalsIgnoreCase("y") && !another.equalsIgnoreCase("yes")) {
                System.out.println("Please answer 'yes' or 'no'.");
                another = input.getString("\"Would you like to go back to the main menu?");
            }

        } while (another.equalsIgnoreCase("y") || (another.equalsIgnoreCase("yes")));
        exit(filehandler, contacts);


    }



}