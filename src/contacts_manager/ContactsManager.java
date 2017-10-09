package contacts_manager;

import util.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class ContactsManager {
    public static Input input = new Input();


    // DISPLAY ALL CONTACTS----------------------------------------------------------
    public static void displayMenu() {
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("\nEnter an option (1, 2, 3, 4 or 5):");
    }


    // PRINT ALL CONTACTS----------------------------------------------------------
    public static void printAllContacts(List<String> s) {
        System.out.printf("Name               |  Phone Number |\n" +
                "------------------------------------");
        System.out.println("");
        for (String contact : s) {
            String[] contactParts = contact.split("[|]");
            System.out.printf("%-19s| %-12s |\n", contactParts[0], phoneFormatter(contactParts[1].trim()));
        }
    }


    // ADD CONTACTS --------------------------------------------------------------
    public static void addContact(List<String> contacts) {

        String addContactName = input.getString("Add a contact Name:");

        for (char contact : addContactName.toCharArray()) {
            if (!Character.isLetter(contact) && !Character.isSpaceChar(contact) && (contact != '-')) {
                System.out.println("The name can not be a number. Please enter a valid name");
                System.out.println("invalid");
                addContact(contacts);
                return;
            }
        }
        String addContactNumber = input.getPhoneNumber("Add the contact number:");
        contacts.add(addContactName + " | " + addContactNumber);
    }






    // SEARCH BY NAME --------------------------------------------------------------
    public static String searchByName(List<String> contacts) {
        namesOnly(contacts);
        String searchByName = input.getString("\nSearch Contact name:");

        for (String contact : contacts) {
            String[] contactSearch = contact.split(Pattern.quote("|"));

            if (contactSearch[0].trim().equalsIgnoreCase(searchByName)) {
                return "\n" + contact;
            }
        }
        System.out.println("\nSorry that is not a valid input.");
        return "";
    }







    // NAMES ONLY --------------------------------------------------------------
    public static void namesOnly(List<String> contacts) {
        for (String contact : contacts) {
            String[] contName = contact.split(Pattern.quote("|"));
            System.out.println(contName[0]);
        }
    }





    // DELETES CONTACTS--------------------------------------------------------------
    public static List<String> deleteExistingContact(List<String> contacts) {
        List<String> newContactList = new ArrayList<>();

        printAllContacts(contacts);

        String deleteContact = input.getString("\nRemove a contact of your choice");
        boolean nameNotAvailable = true;

        for (String contact : contacts) {
            String[] contactInfo = contact.split(" | ");

            if (contactInfo[0].equalsIgnoreCase(deleteContact)) {
                nameNotAvailable = false;
                continue;
            }
            newContactList.add(contact);
        }
        if (nameNotAvailable) {
            System.out.println("The name you inputted does not match a name on the list!");
        }
        return newContactList;
    }






    // EXIT AND SUBMIT FILES TO CONTACT.TXT------------------------------------------------------
    public static void exit(FileHandler fileHandler, List<String> contacts) {
        System.out.println("Goodbye, have a great day!)");
        fileHandler.writeToFile(contacts);
    }





    // FORMATS PHONE NUMBER INPUT --------------------------------------------------------------
    public static String phoneFormatter(String phoneNumber) {
        String areaCode = phoneNumber.substring(0, 3);
        String threeNumbersAfterAreaCode = phoneNumber.substring(3, 6);
        String lastFourNumbers = phoneNumber.substring(6);
        return "(" + areaCode + ")" + threeNumbersAfterAreaCode + "-" + lastFourNumbers;
    }
}


