package by.bsuir.journal.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by test on 09.03.2016.
 */
@Entity
@Table(name = "task")
public class Task {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int id;

    @Column(length = 50, columnDefinition = "nvarchar", name = "title")
    private String title;

    @Column(length = 255, columnDefinition = "nvarchar", name = "description")
    private String description;

    @Column(name = "datecreated")
    private Timestamp dateCreated;

    @Column(name = "changeddate")
    private Timestamp dateChanged;

    @Column(name = "status")
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @OneToMany(mappedBy = "task")
    private Set<Review> review;

    public enum TaskStatus {
        NEW, ASSIGNED, CLOSED, COMPLETED
    }

    public Task() {}

    public Task(String title, String description, Timestamp dateCreated, Timestamp dateChanged,
                TaskStatus status, User creator, Place place, Set<Review> review) {
        this.title = title;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
        this.status = status;
        this.creator = creator;
        this.place = place;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(Timestamp dateChanged) {
        this.dateChanged = dateChanged;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Set<Review> getReview() {
        return review;
    }

    public void setReview(Set<Review> review) {
        this.review = review;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
