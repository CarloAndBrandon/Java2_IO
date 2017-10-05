package contacts_manager;

public class NameSearch {
    private String name;
    private String phoneNumber;

    public NameSearch(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}