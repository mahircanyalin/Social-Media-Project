import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Main class that sets up the social network application GUI
public class Main {
    // Factory to create users and groups
    private static SocialNetworkFactory factory = new ConcreteSocialNetworkFactory();
    // Models to hold lists of users and groups
    private static DefaultListModel<User> userModel = new DefaultListModel<>();
    private static DefaultListModel<Group> groupModel = new DefaultListModel<>();
    // UI components for displaying users and groups
    private static JList<User> userList = new JList<>(userModel);
    private static JList<Group> groupList = new JList<>(groupModel);
    // Text area to display user posts
    private static JTextArea userPosts = new JTextArea();
    // Models to hold lists of friends and group members
    private static DefaultListModel<User> friendsModel = new DefaultListModel<>();
    private static DefaultListModel<User> groupMembersModel = new DefaultListModel<>();
    private static JList<User> friendsList = new JList<>(friendsModel);
    private static JList<User> groupMembersList = new JList<>(groupMembersModel);

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Social Network");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());

        // Create a panel to hold user and group lists
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        // Panel for users
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BorderLayout());
        userPanel.add(new JLabel("Users"), BorderLayout.NORTH);
        userPanel.add(new JScrollPane(userList), BorderLayout.CENTER);

        // Panel for groups
        JPanel groupPanel = new JPanel();
        groupPanel.setLayout(new BorderLayout());
        groupPanel.add(new JLabel("Groups"), BorderLayout.NORTH);
        groupPanel.add(new JScrollPane(groupList), BorderLayout.CENTER);

        // Add user and group panels to the main panel
        panel.add(userPanel);
        panel.add(groupPanel);

        frame.add(panel, BorderLayout.CENTER);

        // Panel for buttons at the bottom
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 7));

        // Buttons for various actions
        JButton addUserButton = new JButton("Add User");
        JButton addPostButton = new JButton("Add Post");
        JButton addGroupButton = new JButton("Add Group");
        JButton addFriendButton = new JButton("Add Friend");
        JButton addGroupMemberButton = new JButton("Add Group Member");
        JButton changeVisibilityButton = new JButton("Change Visibility");
        JButton searchUserButton = new JButton("Search User");

        // Add buttons to the bottom panel
        bottomPanel.add(addUserButton);
        bottomPanel.add(addPostButton);
        bottomPanel.add(addGroupButton);
        bottomPanel.add(addFriendButton);
        bottomPanel.add(addGroupMemberButton);
        bottomPanel.add(changeVisibilityButton);
        bottomPanel.add(searchUserButton);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Right panel to display user posts and friends
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2, 1));

        // Panel for user posts
        JPanel postPanel = new JPanel();
        postPanel.setLayout(new BorderLayout());
        postPanel.add(new JLabel("User Posts"), BorderLayout.NORTH);
        postPanel.add(new JScrollPane(userPosts), BorderLayout.CENTER);

        // Panel for friends list
        JPanel friendsPanel = new JPanel();
        friendsPanel.setLayout(new BorderLayout());
        friendsPanel.add(new JLabel("Friends"), BorderLayout.NORTH);
        friendsPanel.add(new JScrollPane(friendsList), BorderLayout.CENTER);

        // Add post and friends panels to the right panel
        rightPanel.add(postPanel);
        rightPanel.add(friendsPanel);

        frame.add(rightPanel, BorderLayout.EAST);

        // Panel for group members on the left
        JPanel groupMembersPanel = new JPanel();
        groupMembersPanel.setLayout(new BorderLayout());
        groupMembersPanel.add(new JLabel("Group Members"), BorderLayout.NORTH);
        groupMembersPanel.add(new JScrollPane(groupMembersList), BorderLayout.CENTER);

        frame.add(groupMembersPanel, BorderLayout.WEST);

        // Action listener for adding a new user
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter user name:");
                if (name != null && !name.trim().isEmpty()) {
                    User user = factory.createUser(name);
                    userModel.addElement(user);
                }
            }
        });

        // Action listener for adding a new post
        addPostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User selectedUser = userList.getSelectedValue();
                if (selectedUser != null) {
                    String content = JOptionPane.showInputDialog(frame, "Enter post content:");
                    if (content != null && !content.trim().isEmpty()) {
                        Post post = new Post(content);
                        selectedUser.addPost(post);
                        userPosts.append(selectedUser.getName() + ": " + post.getContent() + "\n");
                    }
                }
            }
        });

        // Action listener for adding a new group
        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter group name:");
                if (name != null && !name.trim().isEmpty()) {
                    Group group = factory.createGroup(name);
                    groupModel.addElement(group);
                }
            }
        });

        // Action listener for adding a friend
        addFriendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User selectedUser = userList.getSelectedValue();
                if (selectedUser != null) {
                    List<User> users = IntStream.range(0, userModel.size())
                                                .mapToObj(userModel::get)
                                                .collect(Collectors.toList());
                    User[] userArray = users.toArray(new User[0]);
                    User friend = (User) JOptionPane.showInputDialog(
                            frame,
                            "Select friend to add:",
                            "Add Friend",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            userArray,
                            userArray[0]
                    );
                    if (friend != null && friend != selectedUser) {
                        selectedUser.addFriend(friend);
                        JOptionPane.showMessageDialog(frame, selectedUser.getName() + " and " + friend.getName() + " are now friends!");
                        updateFriendsList(selectedUser);
                    }
                }
            }
        });

        // Action listener for adding a group member
        addGroupMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Group selectedGroup = groupList.getSelectedValue();
                if (selectedGroup != null) {
                    List<User> users = IntStream.range(0, userModel.size())
                                                .mapToObj(userModel::get)
                                                .collect(Collectors.toList());
                    User[] userArray = users.toArray(new User[0]);
                    User member = (User) JOptionPane.showInputDialog(
                            frame,
                            "Select member to add:",
                            "Add Group Member",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            userArray,
                            userArray[0]
                    );
                    if (member != null) {
                        selectedGroup.add(new UserGroup(member));
                        JOptionPane.showMessageDialog(frame, member.getName() + " added to " + selectedGroup.getName());
                        updateGroupMembersList(selectedGroup);
                    }
                }
            }
        });

        // Action listener for changing visibility of a user
        changeVisibilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User selectedUser = userList.getSelectedValue();
                if (selectedUser != null) {
                    String[] options = {"Public", "Private"};
                    int choice = JOptionPane.showOptionDialog(
                            frame,
                            "Select visibility:",
                            "Change Visibility",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            options,
                            options[0]
                    );
                    if (choice == 0) {
                        selectedUser.setVisibilityStrategy(new PublicVisibility());
                    } else if (choice == 1) {
                        selectedUser.setVisibilityStrategy(new PrivateVisibility());
                    }
                    JOptionPane.showMessageDialog(frame, selectedUser.getName() + " visibility set to " + options[choice]);
                }
            }
        });

        // Action listener for searching a user by name
        searchUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter user name to search:");
                if (name != null && !name.trim().isEmpty()) {
                    List<User> users = IntStream.range(0, userModel.size())
                                                .mapToObj(userModel::get)
                                                .collect(Collectors.toList());
                    User foundUser = null;
                    for (User user : users) {
                        if (user.getName().equalsIgnoreCase(name)) {
                            foundUser = user;
                            break;
                        }
                    }
                    if (foundUser == null) {
                        JOptionPane.showMessageDialog(frame, "User not found.");
                    } else if (foundUser.isVisible()) {
                        JOptionPane.showMessageDialog(frame, "User found: " + foundUser.getName());
                    } else {
                        JOptionPane.showMessageDialog(frame, "User is private and cannot be displayed.");
                    }
                }
            }
        });

        // Listener to update the friends list when a user is selected
        userList.addListSelectionListener(e -> {
            User selectedUser = userList.getSelectedValue();
            if (selectedUser != null) {
                updateFriendsList(selectedUser);
            }
        });

        // Listener to update the group members list when a group is selected
        groupList.addListSelectionListener(e -> {
            Group selectedGroup = groupList.getSelectedValue();
            if (selectedGroup != null) {
                updateGroupMembersList(selectedGroup);
            }
        });

        // Set the frame to be visible
        frame.setVisible(true);
    }

    // Method to update the friends list of a user
    private static void updateFriendsList(User user) {
        friendsModel.clear();
        for (User friend : user.getFriends()) {
            friendsModel.addElement(friend);
        }
    }

    // Method to update the group members list of a group
    private static void updateGroupMembersList(Group group) {
        groupMembersModel.clear();
        for (GroupComponent component : group.getGroupComponents()) {
            if (component instanceof UserGroup) {
                groupMembersModel.addElement(((UserGroup) component).getUser());
            }
        }
    }
}
