// Interface for defining visibility strategies for user search
public interface SearchVisibilityStrategy {
    
    // Method to determine if a user is visible in search results based on the strategy
    boolean isVisible(User user);
}
