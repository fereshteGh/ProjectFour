package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "grantCondition" )
public class GrantCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " grantId")
    private String grantId;
    @Column(name = " grantConditionName")
    private String grantConditionName;
    @Column(name = " maxContractDuration")
    private Integer maxContractDuration;
    @Column(name = " minContractDuration")
    private Integer minContractDuration;
    @Column(name = " maxContractAmount")
    private BigDecimal maxContractAmount;
    @Column(name = " minContractAmount")
    private BigDecimal minContractAmount;

    public GrantCondition() {
    }

    public String getGrantId() {
        return grantId;
    }

    public String getGrantConditionName() {
        return grantConditionName;
    }

    public int getMaxContractDuration() {
        return maxContractDuration;
    }

    public int getMinContractDuration() {
        return minContractDuration;
    }

    public BigDecimal getMaxContractAmount() {
        return maxContractAmount;
    }

    public BigDecimal getMinContractAmount() {
        return minContractAmount;
    }

    public void setGrantId(String grantId) {
        this.grantId = grantId;
    }

    public void setGrantConditionName(String grantConditionName) {
        this.grantConditionName = grantConditionName;
    }

    public void setMaxContractDuration(int maxContractDuration) {
        this.maxContractDuration = maxContractDuration;
    }

    public void setMinContractDuration(int minContractDuration) {
        this.minContractDuration = minContractDuration;
    }

    public void setMaxContractAmount(BigDecimal maxContractAmount) {
        this.maxContractAmount = maxContractAmount;
    }

    public void setMinContractAmount(BigDecimal minContractAmount) {
        this.minContractAmount = minContractAmount;
    }
}
