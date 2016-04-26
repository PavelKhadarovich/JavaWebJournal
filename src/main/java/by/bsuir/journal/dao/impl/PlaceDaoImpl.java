package by.bsuir.journal.dao.impl;

import by.bsuir.journal.dao.AbstractDao;
import by.bsuir.journal.dao.PlaceDao;
import by.bsuir.journal.model.Place;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("placeDao")
public class PlaceDaoImpl extends AbstractDao<Integer, Place> implements PlaceDao {
    public Place findById(int id) {
        Place place = getByKey(id);
        return place;
    }

    public Place findByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name",name));
        Place place = (Place)criteria.uniqueResult();
        return place;
    }

    public void save(Place place) {
        persist(place);
    }

    public void deleteByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name",name));
        Place place = (Place)criteria.uniqueResult();
        delete(place);
    }

    @SuppressWarnings("unchecked")
    public List<Place> findAllPlaces() {
        Criteria criteria = createEntityCriteria().addOrder(
                Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Place> places = (List<Place>)criteria.list();
        return places;
    }
}
