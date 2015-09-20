package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "loanFile" )
public class LoanFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fileId")
    private int id;
    @Column( name = "contractDuration")
    private int contractDuration;
    @Column( name = "contractValue")
    private BigDecimal contractValue;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "loanTypeId")
    private LoanType loanTypeEntities;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private IndividualCustomer individualCustomerEntities;

    public LoanFile() {
    }
    public int getId() {
        return id;
    }
    public int getContractDuration() {
        return contractDuration;
    }

    public BigDecimal getContractValue() {
        return contractValue;
    }

    public LoanType getLoanTypeEntities() {
        return loanTypeEntities;
    }

    public void setLoanTypeEntities(LoanType loanTypeEntities) {
        this.loanTypeEntities = loanTypeEntities;
    }

    public IndividualCustomer getIndividualCustomerEntities() {
        return individualCustomerEntities;
    }

    public void setIndividualCustomerEntities(IndividualCustomer individualCustomerEntities) {
        this.individualCustomerEntities = individualCustomerEntities;    }

    public void setId(int id) {
        this.id = id;
    }


    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    public void setContractValue(BigDecimal contractValue) {
        this.contractValue = contractValue;
    }
}
