// Class representing a user within a group structure
public class UserGroup extends GroupComponent {
    private User user; // User associated with this group component

    // Constructor to initialize the user group with a user
    public UserGroup(User user) {
        this.user = user;
    }

    // Method to display information about the user in this group component
    @Override
    public void displayGroupInfo() {
        System.out.println("User: " + user.getName()); // Display the name of the user
    }

    // Method to get the user associated with this group component
    public User getUser() {
        return user;
    }
}
