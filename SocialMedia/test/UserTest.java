/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author berataltun
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addFriend method, of class User.
     */
    @Test
    public void testAddFriend() {
        System.out.println("addFriend");
        User user = null;
        User instance = null;
        instance.addFriend(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFriends method, of class User.
     */
    @Test
    public void testGetFriends() {
        System.out.println("getFriends");
        User instance = null;
        List<User> expResult = null;
        List<User> result = instance.getFriends();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWall method, of class User.
     */
    @Test
    public void testGetWall() {
        System.out.println("getWall");
        User instance = null;
        List<Post> expResult = null;
        List<Post> result = instance.getWall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class User.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Post post = null;
        User instance = null;
        instance.update(post);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPost method, of class User.
     */
    @Test
    public void testAddPost() {
        System.out.println("addPost");
        Post post = null;
        User instance = null;
        instance.addPost(post);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVisibilityStrategy method, of class User.
     */
    @Test
    public void testSetVisibilityStrategy() {
        System.out.println("setVisibilityStrategy");
        SearchVisibilityStrategy visibilityStrategy = null;
        User instance = null;
        instance.setVisibilityStrategy(visibilityStrategy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVisible method, of class User.
     */
    @Test
    public void testIsVisible() {
        System.out.println("isVisible");
        User instance = null;
        boolean expResult = false;
        boolean result = instance.isVisible();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
