package by.bsuir.journal.service;

import by.bsuir.journal.model.Place;

import java.util.List;


public interface PlaceService {
    Place findById(int id);

    Place findByName(String name);

    void savePlace(Place place);

    void updatePlace(Place place);

    void deletePlaceByName(String name);

    List<Place> findAllPlaces();

    boolean isPlaceNameUnique(Integer id, String name);
}
