package by.bsuir.journal.model.entity;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.List;
import javax.persistence.*;

/**
 * Created by test on 09.03.2016.
 */
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @Column(columnDefinition = "text", name = "text")
    private String text;

    @Column(precision = 10, scale = 2, name = "price")
    private BigDecimal price;

    @Column(name = "status")
    private ReportStatus status;

    private User approver;          // report could have no approver. specify this in a special way or not?

    @ManyToOne
    @JoinColumn(name = "id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "id")
    private User reporter;

    @OneToMany(mappedBy = "report")
    private List<Task> tasks;       // report could have no tasks, should i specify this in a special way or not?

    public enum ReportStatus {
        APPROVED, DECLINED, NEW
    }

    public Report() {}

    public Report(Timestamp dateCreated, String text, BigDecimal price, User reporter, User approver, Place place, ReportStatus status, List<Task> tasks) {
        this.dateCreated = dateCreated;
        this.text = text;
        this.price = price;
        this.reporter = reporter;
        this.approver = approver;
        this.place = place;
        this.status = status;
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getApprover() {
        return approver;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report)) return false;

        Report report = (Report) o;

        if (getId() != report.getId()) return false;
        if (!getDateCreated().equals(report.getDateCreated())) return false;
        if (!getText().equals(report.getText())) return false;
        if (!getPrice().equals(report.getPrice())) return false;
        if (!getReporter().equals(report.getReporter())) return false;
        if (getApprover() != null ? !getApprover().equals(report.getApprover()) : report.getApprover() != null)
            return false;
        if (!getPlace().equals(report.getPlace())) return false;
        if (getStatus() != report.getStatus()) return false;
        return getTasks() != null ? getTasks().equals(report.getTasks()) : report.getTasks() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getDateCreated().hashCode();
        result = 31 * result + getText().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getReporter().hashCode();
        result = 31 * result + (getApprover() != null ? getApprover().hashCode() : 0);
        result = 31 * result + getPlace().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + (getTasks() != null ? getTasks().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", reporter=" + reporter +
                ", approver=" + approver +
                ", place=" + place +
                ", status=" + status +
                ", tasks=" + tasks +
                '}';
    }
}
