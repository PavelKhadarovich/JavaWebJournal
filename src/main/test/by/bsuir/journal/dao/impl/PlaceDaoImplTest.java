package by.bsuir.journal.dao.impl;

import by.bsuir.journal.model.Place;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Вероника on 06.05.2016.
 */
public class PlaceDaoImplTest {
    private PlaceDaoImpl daoMock;

    @Before
    public void setUp() throws Exception {
        daoMock = mock(PlaceDaoImpl.class);
    }

    @Test
    public void testFindById() throws Exception {
        Place place = new Place();
        when(daoMock.findById(any(Integer.class))).thenReturn(place);
        assertEquals(place, daoMock.findById(any(Integer.class)));

    }

    @Test
    public void testFindByName() throws Exception {
        Place place = new Place();
        when(daoMock.findByName(any(String.class))).thenReturn(place);
        assertEquals(place, daoMock.findByName(any(String.class)));

    }

    @Test
    public void testSave() throws Exception {
        Place place = new Place();
        when(daoMock.findById(any(Integer.class))).thenReturn(place);

        daoMock.save(place);
        verify(daoMock).save(any(Place.class));

        verify(daoMock, times(1)).save(any(Place.class));
    }

    @Test
    public void testDeleteByName() throws Exception {
        Place place = new Place();
        when(daoMock.findById(any(Integer.class))).thenReturn(place);

        daoMock.save(place);
        daoMock.deleteByName(place.getName());
        verify(daoMock).save(any(Place.class));
        verify(daoMock).deleteByName(place.getName());

        verify(daoMock, times(1)).save(any(Place.class));
        verify(daoMock, times(1)).deleteByName(any(String.class));
    }

    @Test
    public void testFindAllPlaces() throws Exception {
        assertNotNull(daoMock.findAllPlaces());
    }
}