package custom;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Валерий on 20.07.2016.
 */
//заглушка для FactoryUsers


@Entity
public class Request {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    private Date dateFrom;
    private Date dateTo;

    @ManyToOne(fetch = FetchType.EAGER)
    private FactoryUsers users;

    private String description;

    @OneToMany (fetch = FetchType.EAGER)
    private List<Person> persons = new ArrayList<>();
    @OneToMany (fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private FactoryUsers createdBy;
    @ManyToOne(fetch = FetchType.EAGER)
    private FactoryUsers approvedBy;

    Request() {

    }

    public Request(Date dateFrom, Date dateTo, Company company, FactoryUsers createdBy) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.company = company;
        this.createdBy = createdBy;

    }

    public FactoryUsers getcreatedBy() {
        return createdBy;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public FactoryUsers geapprovedBy() {
        return approvedBy;
    }

    public Integer getId() {
        return id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public String getDescription() {
        return description;
    }

    public Company getCompany() {
        return company;
    }

    public FactoryUsers getUsers() {
        return users;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setUsers(FactoryUsers users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", company=" + company +
                ", dateFrom=" + dateFrom +
                ", users=" + users +
                ", description='" + description + '\'' +
                '}';
    }
}
