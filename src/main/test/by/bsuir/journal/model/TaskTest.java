package by.bsuir.journal.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Вероника on 07.05.2016.
 */
public class TaskTest {

    Task  task = new Task();
    Task  taskForSet = new Task();

    @Before
    public void setUp() throws Exception {
        task.setTitle("title");
        task.setDescription("description");
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("title", task.getTitle());
    }

    @Test
    public void testSetTitle() throws Exception {
        taskForSet.setTitle("title");
        assertEquals("title", taskForSet.getTitle());
    }

    @Test
    public void testGetDescription() throws Exception {
        assertEquals("description", task.getDescription());
    }

    @Test
    public void testSetDescription() throws Exception {
        taskForSet.setDescription("description");
        assertEquals("description", task.getDescription());
    }


}