// Abstract class representing a component in a group structure
public abstract class GroupComponent {

    // Method to add a child component; default implementation throws an exception
    public void add(GroupComponent groupComponent) {
        throw new UnsupportedOperationException();
    }

    // Method to remove a child component; default implementation throws an exception
    public void remove(GroupComponent groupComponent) {
        throw new UnsupportedOperationException();
    }

    // Method to get a child component by index; default implementation throws an exception
    public GroupComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    // Abstract method to display information about the component
    public abstract void displayGroupInfo();
}
