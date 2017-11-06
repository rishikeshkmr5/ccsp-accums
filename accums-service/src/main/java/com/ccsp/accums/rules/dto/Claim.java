
package com.ccsp.accums.rules.dto;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

public class Claim {

    protected double accumulatorINDeductAmount;
    protected double accumulatorINOpexAmount;
    protected double accumulatorONDeductAmount;
    protected double accumulatorONOpexAmount;
    protected int age;
    protected double billedAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar claimEndDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar claimStartDate;
    protected double coInsuranceAmount;
    protected double coPayAmount;
    protected double deductableAmountLeft;
    protected int diagnosticCode;
    protected String diagnosticCodeDesc;
    protected String isCoInsuranceAllowed;
    protected String isCoPayAllowed;
    protected String isDeductableAllowed;
    protected String isIgnoreCostShare;
    protected String isNetwork;
    protected String isServiceAllowed;
    protected double maxDeductableAmountAllowed;
    protected double maximumAllowedAmount;
    protected int memberId;
    protected int noOfdays;
    protected double paidByCompanyInsuranceAmount;
    protected double patientCoInsuranceAmount;
    protected double patientCoPayAmount;
    protected double patientDeductableAmount;
    protected String planId;
    protected String planName;
    protected int procedureCode;
    protected String procedureCodeDesc;
    protected int serviceCode;
    protected String serviceName;
    protected double totalDeductableAmount;

    /**
     * Gets the value of the accumulatorINDeductAmount property.
     * 
     */
    public double getAccumulatorINDeductAmount() {
        return accumulatorINDeductAmount;
    }

    /**
     * Sets the value of the accumulatorINDeductAmount property.
     * 
     */
    public void setAccumulatorINDeductAmount(double value) {
        this.accumulatorINDeductAmount = value;
    }

    /**
     * Gets the value of the accumulatorINOpexAmount property.
     * 
     */
    public double getAccumulatorINOpexAmount() {
        return accumulatorINOpexAmount;
    }

    /**
     * Sets the value of the accumulatorINOpexAmount property.
     * 
     */
    public void setAccumulatorINOpexAmount(double value) {
        this.accumulatorINOpexAmount = value;
    }

    /**
     * Gets the value of the accumulatorONDeductAmount property.
     * 
     */
    public double getAccumulatorONDeductAmount() {
        return accumulatorONDeductAmount;
    }

    /**
     * Sets the value of the accumulatorONDeductAmount property.
     * 
     */
    public void setAccumulatorONDeductAmount(double value) {
        this.accumulatorONDeductAmount = value;
    }

    /**
     * Gets the value of the accumulatorONOpexAmount property.
     * 
     */
    public double getAccumulatorONOpexAmount() {
        return accumulatorONOpexAmount;
    }

    /**
     * Sets the value of the accumulatorONOpexAmount property.
     * 
     */
    public void setAccumulatorONOpexAmount(double value) {
        this.accumulatorONOpexAmount = value;
    }

    /**
     * Gets the value of the age property.
     * 
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     */
    public void setAge(int value) {
        this.age = value;
    }

    /**
     * Gets the value of the billedAmount property.
     * 
     */
    public double getBilledAmount() {
        return billedAmount;
    }

    /**
     * Sets the value of the billedAmount property.
     * 
     */
    public void setBilledAmount(double value) {
        this.billedAmount = value;
    }

    /**
     * Gets the value of the claimEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClaimEndDate() {
        return claimEndDate;
    }

    /**
     * Sets the value of the claimEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClaimEndDate(XMLGregorianCalendar value) {
        this.claimEndDate = value;
    }

    /**
     * Gets the value of the claimStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClaimStartDate() {
        return claimStartDate;
    }

    /**
     * Sets the value of the claimStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClaimStartDate(XMLGregorianCalendar value) {
        this.claimStartDate = value;
    }

    /**
     * Gets the value of the coInsuranceAmount property.
     * 
     */
    public double getCoInsuranceAmount() {
        return coInsuranceAmount;
    }

    /**
     * Sets the value of the coInsuranceAmount property.
     * 
     */
    public void setCoInsuranceAmount(double value) {
        this.coInsuranceAmount = value;
    }

    /**
     * Gets the value of the coPayAmount property.
     * 
     */
    public double getCoPayAmount() {
        return coPayAmount;
    }

    /**
     * Sets the value of the coPayAmount property.
     * 
     */
    public void setCoPayAmount(double value) {
        this.coPayAmount = value;
    }

    /**
     * Gets the value of the deductableAmountLeft property.
     * 
     */
    public double getDeductableAmountLeft() {
        return deductableAmountLeft;
    }

    /**
     * Sets the value of the deductableAmountLeft property.
     * 
     */
    public void setDeductableAmountLeft(double value) {
        this.deductableAmountLeft = value;
    }

    /**
     * Gets the value of the diagnosticCode property.
     * 
     */
    public int getDiagnosticCode() {
        return diagnosticCode;
    }

    /**
     * Sets the value of the diagnosticCode property.
     * 
     */
    public void setDiagnosticCode(int value) {
        this.diagnosticCode = value;
    }

    /**
     * Gets the value of the diagnosticCodeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagnosticCodeDesc() {
        return diagnosticCodeDesc;
    }

    /**
     * Sets the value of the diagnosticCodeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagnosticCodeDesc(String value) {
        this.diagnosticCodeDesc = value;
    }

    /**
     * Gets the value of the isCoInsuranceAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsCoInsuranceAllowed() {
        return isCoInsuranceAllowed;
    }

    /**
     * Sets the value of the isCoInsuranceAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCoInsuranceAllowed(String value) {
        this.isCoInsuranceAllowed = value;
    }

    /**
     * Gets the value of the isCoPayAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsCoPayAllowed() {
        return isCoPayAllowed;
    }

    /**
     * Sets the value of the isCoPayAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCoPayAllowed(String value) {
        this.isCoPayAllowed = value;
    }

    /**
     * Gets the value of the isDeductableAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDeductableAllowed() {
        return isDeductableAllowed;
    }

    /**
     * Sets the value of the isDeductableAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDeductableAllowed(String value) {
        this.isDeductableAllowed = value;
    }

    /**
     * Gets the value of the isIgnoreCostShare property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsIgnoreCostShare() {
        return isIgnoreCostShare;
    }

    /**
     * Sets the value of the isIgnoreCostShare property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsIgnoreCostShare(String value) {
        this.isIgnoreCostShare = value;
    }

    /**
     * Gets the value of the isNetwork property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsNetwork() {
        return isNetwork;
    }

    /**
     * Sets the value of the isNetwork property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsNetwork(String value) {
        this.isNetwork = value;
    }

    /**
     * Gets the value of the isServiceAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsServiceAllowed() {
        return isServiceAllowed;
    }

    /**
     * Sets the value of the isServiceAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsServiceAllowed(String value) {
        this.isServiceAllowed = value;
    }

    /**
     * Gets the value of the maxDeductableAmountAllowed property.
     * 
     */
    public double getMaxDeductableAmountAllowed() {
        return maxDeductableAmountAllowed;
    }

    /**
     * Sets the value of the maxDeductableAmountAllowed property.
     * 
     */
    public void setMaxDeductableAmountAllowed(double value) {
        this.maxDeductableAmountAllowed = value;
    }

    /**
     * Gets the value of the maximumAllowedAmount property.
     * 
     */
    public double getMaximumAllowedAmount() {
        return maximumAllowedAmount;
    }

    /**
     * Sets the value of the maximumAllowedAmount property.
     * 
     */
    public void setMaximumAllowedAmount(double value) {
        this.maximumAllowedAmount = value;
    }

    /**
     * Gets the value of the memberId property.
     * 
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * Sets the value of the memberId property.
     * 
     */
    public void setMemberId(int value) {
        this.memberId = value;
    }

    /**
     * Gets the value of the noOfdays property.
     * 
     */
    public int getNoOfdays() {
        return noOfdays;
    }

    /**
     * Sets the value of the noOfdays property.
     * 
     */
    public void setNoOfdays(int value) {
        this.noOfdays = value;
    }

    /**
     * Gets the value of the paidByCompanyInsuranceAmount property.
     * 
     */
    public double getPaidByCompanyInsuranceAmount() {
        return paidByCompanyInsuranceAmount;
    }

    /**
     * Sets the value of the paidByCompanyInsuranceAmount property.
     * 
     */
    public void setPaidByCompanyInsuranceAmount(double value) {
        this.paidByCompanyInsuranceAmount = value;
    }

    /**
     * Gets the value of the patientCoInsuranceAmount property.
     * 
     */
    public double getPatientCoInsuranceAmount() {
        return patientCoInsuranceAmount;
    }

    /**
     * Sets the value of the patientCoInsuranceAmount property.
     * 
     */
    public void setPatientCoInsuranceAmount(double value) {
        this.patientCoInsuranceAmount = value;
    }

    /**
     * Gets the value of the patientCoPayAmount property.
     * 
     */
    public double getPatientCoPayAmount() {
        return patientCoPayAmount;
    }

    /**
     * Sets the value of the patientCoPayAmount property.
     * 
     */
    public void setPatientCoPayAmount(double value) {
        this.patientCoPayAmount = value;
    }

    /**
     * Gets the value of the patientDeductableAmount property.
     * 
     */
    public double getPatientDeductableAmount() {
        return patientDeductableAmount;
    }

    /**
     * Sets the value of the patientDeductableAmount property.
     * 
     */
    public void setPatientDeductableAmount(double value) {
        this.patientDeductableAmount = value;
    }

    /**
     * Gets the value of the planId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanId() {
        return planId;
    }

    /**
     * Sets the value of the planId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanId(String value) {
        this.planId = value;
    }

    /**
     * Gets the value of the planName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * Sets the value of the planName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanName(String value) {
        this.planName = value;
    }

    /**
     * Gets the value of the procedureCode property.
     * 
     */
    public int getProcedureCode() {
        return procedureCode;
    }

    /**
     * Sets the value of the procedureCode property.
     * 
     */
    public void setProcedureCode(int value) {
        this.procedureCode = value;
    }

    /**
     * Gets the value of the procedureCodeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcedureCodeDesc() {
        return procedureCodeDesc;
    }

    /**
     * Sets the value of the procedureCodeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcedureCodeDesc(String value) {
        this.procedureCodeDesc = value;
    }

    /**
     * Gets the value of the serviceCode property.
     * 
     */
    public int getServiceCode() {
        return serviceCode;
    }

    /**
     * Sets the value of the serviceCode property.
     * 
     */
    public void setServiceCode(int value) {
        this.serviceCode = value;
    }

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Gets the value of the totalDeductableAmount property.
     * 
     */
    public double getTotalDeductableAmount() {
        return totalDeductableAmount;
    }

    /**
     * Sets the value of the totalDeductableAmount property.
     * 
     */
    public void setTotalDeductableAmount(double value) {
        this.totalDeductableAmount = value;
    }

}
