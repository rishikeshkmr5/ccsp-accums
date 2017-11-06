
package com.ccsp.accums.rules.dto;

public class RulesResponse {

    protected Claim claimresponse;
    protected ErrorList errorList;
    protected ExceptionList exceptionList;
    protected ResponseMessages responseMessageList;

    /**
     * Gets the value of the claimresponse property.
     * 
     * @return
     *     possible object is
     *     {@link Claim }
     *     
     */
    public Claim getClaimresponse() {
        return claimresponse;
    }

    /**
     * Sets the value of the claimresponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Claim }
     *     
     */
    public void setClaimresponse(Claim value) {
        this.claimresponse = value;
    }

    /**
     * Gets the value of the errorList property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorList }
     *     
     */
    public ErrorList getErrorList() {
        return errorList;
    }

    /**
     * Sets the value of the errorList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorList }
     *     
     */
    public void setErrorList(ErrorList value) {
        this.errorList = value;
    }

    /**
     * Gets the value of the exceptionList property.
     * 
     * @return
     *     possible object is
     *     {@link ExceptionList }
     *     
     */
    public ExceptionList getExceptionList() {
        return exceptionList;
    }

    /**
     * Sets the value of the exceptionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExceptionList }
     *     
     */
    public void setExceptionList(ExceptionList value) {
        this.exceptionList = value;
    }

    /**
     * Gets the value of the responseMessageList property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseMessages }
     *     
     */
    public ResponseMessages getResponseMessageList() {
        return responseMessageList;
    }

    /**
     * Sets the value of the responseMessageList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseMessages }
     *     
     */
    public void setResponseMessageList(ResponseMessages value) {
        this.responseMessageList = value;
    }

}
