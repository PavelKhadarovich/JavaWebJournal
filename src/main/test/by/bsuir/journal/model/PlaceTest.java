package by.bsuir.journal.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Вероника on 05.05.2016.
 */
public class PlaceTest {

    private Place place = new Place();
    private Place placeForSet = new Place();

    @Before
    public void setUp() throws Exception {
        place.setName("name");
        place.setDescription("description");
        place.setEmail("email");
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("name", place.getName());
    }

    @Test
    public void testSetName() throws Exception {
        placeForSet.setName("name");
        assertEquals("name", place.getName());
    }

    @Test
    public void testGetDescription() throws Exception {
        assertEquals("description", place.getDescription());
    }

    @Test
    public void testSetDescription() throws Exception {
        placeForSet.setDescription("description");
        assertEquals("description", place.getDescription());
    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("email", place.getEmail());
    }

    @Test
    public void testSetEmail() throws Exception {
        placeForSet.setEmail("email");
        assertEquals("email", place.getEmail());
    }
}