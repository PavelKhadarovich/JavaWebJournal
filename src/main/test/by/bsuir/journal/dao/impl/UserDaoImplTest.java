package by.bsuir.journal.dao.impl;


import by.bsuir.journal.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class UserDaoImplTest {

    private UserDaoImpl userDaoMock;

    @Before
    public void setUp() throws Exception {
        userDaoMock = mock(UserDaoImpl.class);
    }

    @Test
    public void testFindById() throws Exception {
        User user = new User();
        when(userDaoMock.findById(any(Integer.class))).thenReturn(user);
        assertEquals(user, userDaoMock.findById(any(Integer.class)));

    }

    @Test
    public void testFindBySSO() throws Exception {
        User user = new User();
        when(userDaoMock.findBySSO(any(String.class))).thenReturn(user);
        assertEquals(user, userDaoMock.findBySSO(any(String.class)));
    }

    @Test
    public void testFindAllUsers() throws Exception {
        assertNotNull(userDaoMock.findAllUsers());
    }

    @Test
    public void testSaveAndDeleteBySSO() throws Exception {
        User user = new User();
        when(userDaoMock.findById(any(Integer.class))).thenReturn(user);

        userDaoMock.save(user);
        userDaoMock.deleteBySSO("");

        verify(userDaoMock).save(any(User.class));
        verify(userDaoMock).deleteBySSO("");
        verify(userDaoMock, times(1)).save(any(User.class));
        verify(userDaoMock, times(1)).deleteBySSO("");
    }
}