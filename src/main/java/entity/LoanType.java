package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loanType" )
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " loanTypeId")
    private int loanTypeId;
    @Column(name = " loanTypeName")
    private String loanTypeName;
    @Column(name = " interestRate")
    private double interestRate;
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "loanTypeId")
    private List<GrantCondition> grantConditionList;

    public LoanType() {
    }

    public int getLoanTypeId() {
        return loanTypeId;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public List<GrantCondition> getGrantConditionList() {
        return grantConditionList;
    }

    public void setLoanTypeId(int loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setGrantConditionList(List<GrantCondition> grantConditionList) {
        this.grantConditionList = grantConditionList;
    }
}
