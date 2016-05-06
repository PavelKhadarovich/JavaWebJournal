package by.bsuir.journal.service.impl;

import by.bsuir.journal.dao.impl.TaskDaoImpl;
import by.bsuir.journal.model.Task;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Вероника on 05.05.2016.
 */
public class TaskServiceImplTest {

    private TaskDaoImpl daoMock;
    private TaskServiceImpl serviceMock;

    @Before
    public void setUp() throws Exception {
        daoMock = mock(TaskDaoImpl.class);
        serviceMock = new TaskServiceImpl(daoMock);
    }

    @Test
    public void testFindById() throws Exception {
        Task task = new Task();
        when(serviceMock.findById(any(Integer.class))).thenReturn(task);
        assertEquals(task, serviceMock.findById(any(Integer.class)));
    }

    @Test
    public void testFindByTitle() throws Exception {
        Task task = new Task();
        when(serviceMock.findByTitle(any(String .class))).thenReturn(task);
        assertEquals(task, serviceMock.findByTitle(any(String.class)));
    }

    @Test
    public void testFindByPlaceId() throws Exception {
        Task task = new Task();
        when(serviceMock.findByPlaceId(any(Integer.class))).thenReturn(task);
        assertEquals(task, serviceMock.findByPlaceId(any(Integer.class)));
    }


    @Test
    public void testSaveAndDeleteTaskByTitle() throws Exception {
        Task task = new Task();
        when(serviceMock.findByPlaceId(any(Integer.class))).thenReturn(task);

        serviceMock.saveTask(task);
        serviceMock.deleteTaskByTitle(task.getTitle());
        verify(daoMock).save(any(Task.class));
        verify(daoMock).deleteByTitle(any(String.class));

        verify(daoMock, times(1)).save(any(Task.class));
        verify(daoMock, times(1)).deleteByTitle(any(String .class));
    }

    @Test
    public void testFindAllTasks() throws Exception {
        assertNotNull(serviceMock.findAllTasks());
    }

    @Test
    public void testIsTaskTitleUnique() throws Exception {
        Task task = new Task();
        when(daoMock.findById(anyInt())).thenReturn(task);
        assertTrue(serviceMock.isTaskTitleUnique(task.getId(), task.getTitle()));
    }
}