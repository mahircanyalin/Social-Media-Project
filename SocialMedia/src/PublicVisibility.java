// Class implementing the public visibility strategy for user search
public class PublicVisibility implements SearchVisibilityStrategy {

    // Method to determine if a user is visible in search (always returns true for public visibility)
    @Override
    public boolean isVisible(User user) {
        // User is always visible in search
        return true;
    }
}
