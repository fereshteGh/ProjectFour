package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "loanFile")
public class LoanFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fileId")
    private int id;
    @Column(name = "contractDuration")
    private int contractDuration;
    @Column(name = "contractValue")
    private BigDecimal contractValue;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loanTypeId")
    private LoanType loanType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private IndividualCustomer individualCustomer;

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

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public IndividualCustomer getIndividualCustomer() {
        return individualCustomer;
    }

    public void setIndividualCustomer(IndividualCustomer individualCustomer) {
        this.individualCustomer = individualCustomer;
    }

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
