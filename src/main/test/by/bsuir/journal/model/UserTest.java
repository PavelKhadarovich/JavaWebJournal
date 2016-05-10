package by.bsuir.journal.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User user = new User();
    private User userForSet = new User();

    @Before
    public void setUp() throws Exception {
        user.setSsoId("login");
        user.setFirstName("anna");
        user.setLastName("ivanova");
        user.setEmail("annaivanova@gmail.com");
        user.setPassword("1234");
    }

    @Test
    public void testGetSsoId() throws Exception {
        assertEquals("login", user.getSsoId());
    }

    @Test
    public void testSetSsoId() throws Exception {
        userForSet.setSsoId("login");
        assertEquals("login", userForSet.getSsoId());
    }

    @Test
    public void testGetPassword() throws Exception {
        assertEquals("1234", user.getPassword());
    }

    @Test
    public void testSetPassword() throws Exception {
        userForSet.setPassword("1234");
        assertEquals("1234", userForSet.getPassword());
    }

    @Test
    public void testGetFirstName() throws Exception {
        assertEquals("anna", user.getFirstName());
    }

    @Test
    public void testSetFirstName() throws Exception {
        userForSet.setFirstName("name");
        assertEquals("name", userForSet.getFirstName());
    }

    @Test
    public void testGetLastName() throws Exception {
        assertEquals("ivanova", user.getLastName());
    }

    @Test
    public void testSetLastName() throws Exception {
        userForSet.setLastName("last");
        assertEquals("last", userForSet.getLastName());
    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("annaivanova@gmail.com", user.getEmail());
    }

    @Test
    public void testSetEmail() throws Exception {
        userForSet.setEmail("email");
        assertEquals("email", userForSet.getEmail());
    }

}