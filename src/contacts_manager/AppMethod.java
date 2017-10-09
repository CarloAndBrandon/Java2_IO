package contacts_manager;

import java.util.List;

public class AppMethod extends ContactsManager{
    public static void greatCommandLineProgram() throws Exception {

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
            another = input.getString("\nWould you like to go back to the main menu?");
            System.out.println("");

            while (!another.equalsIgnoreCase("n") && !another.equalsIgnoreCase("no") &&
                    !another.equalsIgnoreCase("y") && !another.equalsIgnoreCase("yes")) {
                System.out.println("Please answer 'yes' or 'no'.");
                another = input.getString("Would you like to go back to the main menu?");
                System.out.println("");
            }

        } while (another.equalsIgnoreCase("y") || (another.equalsIgnoreCase("yes")));
        exit(filehandler, contacts);
    }
}

