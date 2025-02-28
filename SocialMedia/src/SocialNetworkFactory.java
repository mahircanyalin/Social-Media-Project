// Abstract factory for creating users and groups in a social network
public abstract class SocialNetworkFactory {

    // Method to create a new user with the given name
    public abstract User createUser(String name);

    // Method to create a new group with the given name
    public abstract Group createGroup(String name);
}
