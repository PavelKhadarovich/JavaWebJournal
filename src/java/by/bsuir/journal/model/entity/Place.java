package by.bsuir.journal.model.entity;

import javax.persistence.*;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;


/**
 * Created by test on 09.03.2016.
 */
@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(length = 255, name = "name")
    private String name;

    @Column(length = 500, name = "description")
    private String description;

    @Column(length = 35, name = "city")
    private String city;

    @Column(length = 50, name = "street")
    private String street;

    @Column(name = "house")
    private Integer house;

    @Column(length = 255, name = "email")
    private String email;

    @Column(name = "place")
    private PlaceType place;

    @OneToMany(mappedBy = "place")
    private List<Review> reviews;

    @OneToMany(mappedBy = "place")
    private List<Report> reports;

    public enum PlaceType {
        RESTAURANT, CLUB, THEATER, GALLERY, CASINO
    }

    public Place() {}

    public Place(String name, String description, String city, String street, Integer house, String email, PlaceType place, List<Review> reviews, List<Report> reports) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.street = street;
        this.house = house;
        this.email = email;
        this.place = place;
        this.reviews = reviews;
        this.reports = reports;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PlaceType getPlace() {
        return place;
    }

    public void setPlace(PlaceType place) {
        this.place = place;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;

        Place place1 = (Place) o;

        if (getId() != place1.getId()) return false;
        if (!getName().equals(place1.getName())) return false;
        if (!getDescription().equals(place1.getDescription())) return false;
        if (!getCity().equals(place1.getCity())) return false;
        if (!getStreet().equals(place1.getStreet())) return false;
        if (getHouse() != null ? !getHouse().equals(place1.getHouse()) : place1.getHouse() != null) return false;
        if (!getEmail().equals(place1.getEmail())) return false;
        if (getPlace() != place1.getPlace()) return false;
        if (!getReviews().equals(place1.getReviews())) return false;
        return getReports().equals(place1.getReports());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getStreet().hashCode();
        result = 31 * result + (getHouse() != null ? getHouse().hashCode() : 0);
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPlace().hashCode();
        result = 31 * result + getReviews().hashCode();
        result = 31 * result + getReports().hashCode();
        return result;
    }
}
