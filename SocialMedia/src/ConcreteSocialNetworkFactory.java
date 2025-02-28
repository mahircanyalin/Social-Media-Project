// Concrete implementation of the SocialNetworkFactory
public class ConcreteSocialNetworkFactory extends SocialNetworkFactory {

    // Method to create a new User with the given name
    @Override
    public User createUser(String name) {
        // Creates and returns a new User object
        return new User(name);
    }

    // Method to create a new Group with the given name
    @Override
    public Group createGroup(String name) {
        // Creates and returns a new Group object
        return new Group(name);
    }
}
