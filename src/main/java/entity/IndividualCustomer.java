package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "individualCustomer" )
@PrimaryKeyJoinColumn(name = "customerId")
public class IndividualCustomer extends Customer {
    @Column(name = " firstName")
    private String firstName;
    @Column(name = " lastName")
    private String lastName;
    @Column(name = " birthDate")
    private String birthDate;
    @Column(name = " nationalCode")
    private String nationalCode;

    public IndividualCustomer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Override
    public String toString() {
        return "IndividualCustomer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", nationalCode='" + nationalCode + '\'' +
                '}';
    }
}
