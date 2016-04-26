package by.bsuir.journal.model;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by test on 09.03.2016.
 */
@Entity
@Table(name = "place")
public class Place {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "place_id")
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

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "place")
    private Set<Review> reviews;

//    public enum PlaceType {
//        RESTAURANT, CLUB, THEATER, GALLERY, CASINO
//    }

    public Place() {}

    public Place(String name, String description, String city, String street, Integer house, String email, String place, Set<Review> reviews) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.street = street;
        this.house = house;
        this.email = email;
        this.type = place;
        this.reviews = reviews;
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

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
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

    public String getType() {
        return type;
    }

    public void setType(String place) {
        this.type = place;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", email='" + email + '\'' +
                ", place=" + type +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place1 = (Place) o;

        if (id != place1.id) return false;
        if (name != null ? !name.equals(place1.name) : place1.name != null) return false;
        if (description != null ? !description.equals(place1.description) : place1.description != null) return false;
        if (city != null ? !city.equals(place1.city) : place1.city != null) return false;
        if (street != null ? !street.equals(place1.street) : place1.street != null) return false;
        if (house != null ? !house.equals(place1.house) : place1.house != null) return false;
        if (email != null ? !email.equals(place1.email) : place1.email != null) return false;
        if (type != place1.type) return false;
        return reviews != null ? reviews.equals(place1.reviews) : place1.reviews == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (reviews != null ? reviews.hashCode() : 0);
        return result;
    }
}
