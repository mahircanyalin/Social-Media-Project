// Class implementing the private visibility strategy for user search
public class PrivateVisibility implements SearchVisibilityStrategy {

    // Method to determine if a user is visible in search (always returns false for private visibility)
    @Override
    public boolean isVisible(User user) {
        // User is not visible in search
        return false;
    }
}
