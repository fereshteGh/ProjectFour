package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "legalCustomer")
@PrimaryKeyJoinColumn(name = "customerId")
public class LegalCustomer extends Customer {
    @Column(name = " companyName")
    private String companyName;
    @Column(name = " registerDate")
    private String registerDate;
    @Column(name = " economyId")
    private String economyId;

    public LegalCustomer() {

    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getEconomyId() {
        return economyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public void setEconomyId(String economyId) {
        this.economyId = economyId;
    }
}
