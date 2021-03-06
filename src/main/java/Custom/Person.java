package custom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Валерий on 20.07.2016.
 */
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private String passportIdentification;
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportIdentification() {
        return passportIdentification;
    }

    public void setPassportIdentification(String passportIdentification) {
        this.passportIdentification = passportIdentification;
    }

    protected Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Person() {

    }

    public Person(String firstName, String lastName, String companyName, String passportIdentification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.passportIdentification = passportIdentification;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", passportIdentification='" + passportIdentification + '\'' +
                '}';
    }
}
