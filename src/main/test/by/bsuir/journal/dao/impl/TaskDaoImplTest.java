package by.bsuir.journal.dao.impl;

import by.bsuir.journal.model.Task;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Вероника on 06.05.2016.
 */
public class TaskDaoImplTest {

    private TaskDaoImpl daoMock;

    @Before
    public void setUp() throws Exception {
        daoMock = mock(TaskDaoImpl.class);
    }

    @Test
    public void testFindById() throws Exception {
        Task task = new Task();
        when(daoMock.findById(any(Integer.class))).thenReturn(task);
        assertEquals(task, daoMock.findById(any(Integer.class)));

    }

    @Test
    public void testFindByPlaceId() throws Exception {
        Task task = new Task();
        when(daoMock.findByPlaceId(any(Integer.class))).thenReturn(task);
        assertEquals(task, daoMock.findByPlaceId(any(Integer.class)));

    }

    @Test
    public void testFindByTitle() throws Exception {
        Task task = new Task();
        when(daoMock.findByTitle(any(String .class))).thenReturn(task);
        assertEquals(task, daoMock.findByTitle(any(String.class)));

    }

    @Test
    public void testSave() throws Exception {
        Task task = new Task();
        when(daoMock.findByPlaceId(any(Integer.class))).thenReturn(task);

        daoMock.save(task);

        verify(daoMock).save(any(Task.class));
        verify(daoMock, times(1)).save(any(Task.class));
    }

    @Test
    public void testDeleteByTitle() throws Exception {
        Task task = new Task();
        when(daoMock.findByPlaceId(any(Integer.class))).thenReturn(task);

        daoMock.deleteByTitle(task.getTitle());

        verify(daoMock).deleteByTitle(any(String.class));
        verify(daoMock, times(1)).deleteByTitle(any(String .class));

    }

    @Test
    public void testFindAllTasks() throws Exception {
        assertNotNull(daoMock.findAllTasks());
    }
}