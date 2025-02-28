import java.util.ArrayList;
import java.util.List;

// Group class represents a group in the social network
public class Group extends GroupComponent {
    // Name of the group
    private String name;
    // List to hold child components of the group (which can be users or other groups)
    private List<GroupComponent> groupComponents = new ArrayList<>();

    // Constructor to initialize the group with a name
    public Group(String name) {
        this.name = name;
    }

    // Method to add a child component to the group
    @Override
    public void add(GroupComponent groupComponent) {
        groupComponents.add(groupComponent);
    }

    // Method to remove a child component from the group
    @Override
    public void remove(GroupComponent groupComponent) {
        groupComponents.remove(groupComponent);
    }

    // Method to get a child component at a specific index
    @Override
    public GroupComponent getChild(int i) {
        return groupComponents.get(i);
    }

    // Method to get the list of all child components in the group
    public List<GroupComponent> getGroupComponents() {
        return groupComponents;
    }

    // Method to display information about the group and its components
    @Override
    public void displayGroupInfo() {
        System.out.println("Group: " + name);
        // Recursively display info for all child components
        for (GroupComponent groupComponent : groupComponents) {
            groupComponent.displayGroupInfo();
        }
    }

    // Method to get the name of the group
    public String getName() {
        return name;
    }

    // Override toString method to return the name of the group
    @Override
    public String toString() {
        return name;
    }
}
