package by.bsuir.journal.service.impl;

import by.bsuir.journal.dao.impl.PlaceDaoImpl;
import by.bsuir.journal.model.Place;
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
public class PlaceServiceImplTest {

    private PlaceDaoImpl daoMock;
    private PlaceServiceImpl serviceMock;

    @Before
    public void setUp() throws Exception {
        daoMock = mock(PlaceDaoImpl.class);
        serviceMock = new PlaceServiceImpl(daoMock);
    }

    @Test
    public void testFindById() throws Exception {
        Place place = new Place();
        when(serviceMock.findById(any(Integer.class))).thenReturn(place);
        assertEquals(place, serviceMock.findById(any(Integer.class)));
    }

    @Test
    public void testFindByName() throws Exception {
        Place place = new Place();
        when(serviceMock.findByName(any(String.class))).thenReturn(place);
        assertEquals(place, serviceMock.findByName(any(String.class)));
    }

    @Test
    public void testSavePlace() throws Exception {
        Place place = new Place();
        when(serviceMock.findById(any(Integer.class))).thenReturn(place);

        serviceMock.savePlace(place);
        verify(daoMock).save(any(Place.class));

        verify(daoMock, times(1)).save(any(Place.class));
    }

    @Test
    public void testDeletePlaceByName() throws Exception {
        Place place = new Place();
        when(serviceMock.findById(any(Integer.class))).thenReturn(place);

        serviceMock.savePlace(place);
        serviceMock.deletePlaceByName(place.getName());
        verify(daoMock).save(any(Place.class));
        verify(daoMock).deleteByName(place.getName());

        verify(daoMock, times(1)).save(any(Place.class));
        verify(daoMock, times(1)).deleteByName(any(String.class));
    }

    @Test
    public void testFindAllPlaces() throws Exception {
        assertNotNull(serviceMock.findAllPlaces());
    }

    @Test
    public void testIsPlaceNameUnique() throws Exception {
        Place place = new Place();
        when(serviceMock.findById(any(Integer.class))).thenReturn(place);

        assertTrue(serviceMock.isPlaceNameUnique(place.getId(), place.getName()));
    }
}