package by.bsuir.journal.service.impl;

import by.bsuir.journal.dao.PlaceDao;
import by.bsuir.journal.model.Place;
import by.bsuir.journal.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("placeService")
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDao dao;

    public Place findById(int id) {
        return dao.findById(id);
    }

    public Place findByName(String name) {
        Place place = dao.findByName(name);
        return place;
    }

    public void savePlace(Place place) {
        dao.save(place);
    }

    public void updatePlace(Place place) {
        Place entity = dao.findById(place.getId());
        if(entity!=null){
            entity.setName(place.getName());
            entity.setDescription(place.getDescription());
            entity.setCity(place.getCity());
            entity.setStreet(place.getStreet());
            entity.setHouse(place.getHouse());
            entity.setEmail(place.getEmail());
            entity.setType(place.getDescription());
        }
    }

    public void deletePlaceByName(String name) {
        dao.deleteByName(name);
    }

    public List<Place> findAllPlaces() {
        return dao.findAllPlaces();
    }

    public boolean isPlaceNameUnique(Integer id, String name) {
        Place place = findByName(name);
        return (place==null||
                ((id!=null)&&(place.getId()==id)));
    }
}
