package by.bsuir.journal.service.impl;

import by.bsuir.journal.dao.impl.UserProfileDaoImpl;
import by.bsuir.journal.model.UserProfile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Вероника on 05.05.2016.
 */
public class UserProfileServiceImplTest {
    private UserProfileDaoImpl daoMock;
    private UserProfileServiceImpl serviceMock;

    @Before
    public void setUp() throws Exception {
        daoMock = mock(UserProfileDaoImpl.class);
        serviceMock = new UserProfileServiceImpl(daoMock);
    }

    @Test
    public void testFindById() throws Exception {
        UserProfile profile = new UserProfile();
        when(daoMock.findById(any(Integer.class))).thenReturn(profile);

        serviceMock.findById(new Integer(1));

        verify(daoMock).findById(any(Integer.class));
        verify(daoMock, times(1)).findById(any(Integer.class));
    }

    @Test
    public void testFindByType() throws Exception {
        UserProfile profile = new UserProfile();
        when(daoMock.findByType(any(String.class))).thenReturn(profile);

        serviceMock.findByType(new String(""));

        verify(daoMock).findByType(any(String.class));
        verify(daoMock, times(1)).findByType(any(String.class));
    }

    @Test
    public void testFindAll() throws Exception {
        assertNotNull(serviceMock.findAll());
    }
}