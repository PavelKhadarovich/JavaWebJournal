package by.bsuir.journal.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.security.Timestamp;

/**
 * Created by test on 09.03.2016.
 */
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(length = 50, columnDefinition = "nvarchar", name = "title")
    private String title;

    @Column(length = 255, columnDefinition = "nvarchar", name = "description")
    private String description;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @Column(name = "date_changed")
    private Timestamp dateChanged;

    @Column(name = "status")
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "id")
    private Report report;                  // task could have no report should i mark this in a special way?

    @ManyToOne
    @JoinColumn(name = "id")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "id")                // task could have no assigned employee should i mark this in a special way?
    private User assignedEmployee;

    @ManyToOne
    @JoinColumn(name = "id")
    private Review review;

    public enum TaskStatus {
        NEW, ASSIGNED, CLOSED, COMPLETED
    }

    public Task() {}

    public Task(String title, String description, Timestamp dateCreated, Timestamp changeDate, Report report, User creator, User assignedEmployee, Review review, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateChanged = changeDate;
        this.report = report;
        this.creator = creator;
        this.assignedEmployee = assignedEmployee;
        this.review = review;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (!title.equals(task.title)) return false;
        if (!description.equals(task.description)) return false;
        if (!dateCreated.equals(task.dateCreated)) return false;
        if (!dateChanged.equals(task.dateChanged)) return false;
        if (report != null ? !report.equals(task.report) : task.report != null) return false;
        if (!creator.equals(task.creator)) return false;
        if (assignedEmployee != null ? !assignedEmployee.equals(task.assignedEmployee) : task.assignedEmployee != null)
            return false;
        if (!review.equals(task.review)) return false;
        return status == task.status;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + dateCreated.hashCode();
        result = 31 * result + dateChanged.hashCode();
        result = 31 * result + (report != null ? report.hashCode() : 0);
        result = 31 * result + creator.hashCode();
        result = 31 * result + (assignedEmployee != null ? assignedEmployee.hashCode() : 0);
        result = 31 * result + review.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", changeDate=" + dateChanged +
                ", report=" + report +
                ", creator=" + creator +
                ", assignedEmployee=" + assignedEmployee +
                ", review=" + review +
                ", status=" + status +
                '}';
    }
}
