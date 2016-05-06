package by.bsuir.journal.model;

import org.junit.After;
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

    @After
    public void tearDown() throws Exception {

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

    }

    @Test
    public void testGetFirstName() throws Exception {

    }

    @Test
    public void testSetFirstName() throws Exception {
        userForSet.setFirstName("name");
        assertEquals("name", userForSet.getFirstName());
    }

    @Test
    public void testGetLastName() throws Exception {

    }

    @Test
    public void testSetLastName() throws Exception {

    }

    @Test
    public void testGetEmail() throws Exception {

    }

    @Test
    public void testSetEmail() throws Exception {

    }

    @Test
    public void testGetUserProfiles() throws Exception {

    }

    @Test
    public void testSetUserProfiles() throws Exception {

    }
}