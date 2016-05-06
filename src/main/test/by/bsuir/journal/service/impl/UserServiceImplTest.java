package by.bsuir.journal.service.impl;

import by.bsuir.journal.dao.impl.UserDaoImpl;
import by.bsuir.journal.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Вероника on 05.05.2016.
 */
public class UserServiceImplTest {
    private UserDaoImpl userDaoMock;
    private UserServiceImpl userServiceMock;


    @Before
    public void setUp() throws Exception {
        userDaoMock = mock(UserDaoImpl.class);
        userServiceMock = new UserServiceImpl(userDaoMock);

    }

    @Test
    public void testFindById() throws Exception {
        User user = new User();
        when(userServiceMock.findById(any(Integer.class))).thenReturn(user);
        assertEquals(user, userServiceMock.findById(any(Integer.class)));
    }

    @Test
    public void testFindBySSO() throws Exception {
        User user = new User();
        when(userServiceMock.findBySSO(any(String.class))).thenReturn(user);
        assertEquals(user, userServiceMock.findBySSO(any(String.class)));
    }


    @Test
    public void testSaveAndDeleteUser() throws Exception {
        User user = new User();
        when(userDaoMock.findById(any(Integer.class))).thenReturn(user);

        userServiceMock.saveUser(new User());
        userServiceMock.deleteUserBySSO("");

        verify(userDaoMock).save(any(User.class));
        verify(userDaoMock).deleteBySSO("");
        verify(userDaoMock, times(1)).save(any(User.class));
        verify(userDaoMock, times(1)).deleteBySSO("");
    }

    @Test
    public void testFindAllUsers() throws Exception {
        assertNotNull(userServiceMock.findAllUsers());
    }

    @Test
    public void testIsUserSSOUnique() throws Exception {
        User user = new User();
        when(userDaoMock.findById(any(Integer.class))).thenReturn(user);
        Assert.assertTrue(userServiceMock.isUserSSOUnique(user.getId(), user.getSsoId()));
    }
}