package org.aconex.contract.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by muthukumar on 3/31/16.
 */

@Entity
public class Contract {

    @Id
    @GeneratedValue
    private Long contractId;

    private String contractCode;

    private String contractDescription;

    private Date startDate;

    private Date endDate;

    private String vendor;

    private String projectId;

    private double percentComplete;

    @Enumerated(EnumType.STRING)
    private ContractStatus contractStatus;

    private BigDecimal payment;

    private BigDecimal forecast;

    private BigDecimal committed;

    private BigDecimal budget;

    // Default Constructor
    public Contract() {
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractDescription() {
        return contractDescription;
    }

    public void setContractDescription(String contractDescription) {
        this.contractDescription = contractDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(double percentComplete) {
        this.percentComplete = percentComplete;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getForecast() {
        return forecast;
    }

    public void setForecast(BigDecimal forecast) {
        this.forecast = forecast;
    }

    public BigDecimal getCommitted() {
        return committed;
    }

    public void setCommitted(BigDecimal committed) {
        this.committed = committed;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "budget=" + budget +
                ", committed=" + committed +
                ", forecast=" + forecast +
                ", payment=" + payment +
                ", contractStatus=" + contractStatus +
                ", percentComplete=" + percentComplete +
                ", projectId='" + projectId + '\'' +
                ", vendor='" + vendor + '\'' +
                ", endDate=" + endDate +
                ", startDate=" + startDate +
                ", contractDescription='" + contractDescription + '\'' +
                ", contractCode='" + contractCode + '\'' +
                ", contractId=" + contractId +
                '}';
    }
}
