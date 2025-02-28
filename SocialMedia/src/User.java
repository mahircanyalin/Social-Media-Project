import java.util.ArrayList;
import java.util.List;

// Class representing a user in the social network
public class User implements Observer {
    private String name; // Name of the user
    private List<User> friends; // List of friends of the user
    private List<Post> wall; // List of posts on the user's wall
    private SearchVisibilityStrategy visibilityStrategy; // Strategy for user visibility

    // Constructor to initialize the user with a name
    public User(String name) {
        this.name = name;
        this.friends = new ArrayList<>(); // Initialize friends list
        this.wall = new ArrayList<>(); // Initialize wall (posts) list
        this.visibilityStrategy = new PublicVisibility(); // Default visibility strategy
    }

    // Method to add a friend to the user's friends list
    public void addFriend(User user) {
        // Check if the user is not already in the friends list
        if (!this.friends.contains(user)) {
            // Add the user to the friends list
            this.friends.add(user);
            // Add this user to the friend's friends list
            user.addFriend(this);
        }
    }

    // Method to get the list of friends
    public List<User> getFriends() {
        return friends;
    }

    // Method to get the list of posts on the user's wall
    public List<Post> getWall() {
        return wall;
    }

    // Method called when the user is notified of a new post
    @Override
    public void update(Post post) {
        wall.add(post); // Add the new post to the wall
    }

    // Method to add a new post to the user's wall
    public void addPost(Post post) {
        // Add the post to the user's wall
        wall.add(post);
        // Notify friends about the new post
        notifyFriends(post);
    }

    // Method to notify friends about a new post
    private void notifyFriends(Post post) {
        // Iterate through the friends list and notify each friend about the new post
        for (User friend : friends) {
            friend.update(post);
        }
    }

    // Method to set the visibility strategy for the user
    public void setVisibilityStrategy(SearchVisibilityStrategy visibilityStrategy) {
        this.visibilityStrategy = visibilityStrategy;
    }

    // Method to check if the user is visible based on the visibility strategy
    public boolean isVisible() {
        return visibilityStrategy.isVisible(this);
    }

    // Method to get the name of the user
    public String getName() {
        return name;
    }

    // Override toString method to return the name of the user
    @Override
    public String toString() {
        return name;
    }
}
