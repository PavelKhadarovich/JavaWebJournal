package by.bsuir.journal.dao;

import by.bsuir.journal.model.Place;

import java.util.List;

public interface PlaceDao {
    Place findById(int id);

    Place findByName(String name);

    void save(Place place);

    void deleteByName(String name);

    List<Place> findAllPlaces();
}
