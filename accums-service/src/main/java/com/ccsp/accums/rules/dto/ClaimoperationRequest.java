
package com.ccsp.accums.rules.dto;

public class ClaimoperationRequest {

    protected String __DecisionID__;
    protected Claim claim;


    public String get__DecisionID__() {
		return __DecisionID__;
	}

	public void set__DecisionID__(String __DecisionID__) {
		this.__DecisionID__ = __DecisionID__;
	}

	/**
     * Gets the value of the claim property.
     * 
     * @return
     *     possible object is
     *     {@link Claim }
     *     
     */
    public Claim getClaim() {
        return claim;
    }

    /**
     * Sets the value of the claim property.
     * 
     * @param value
     *     allowed object is
     *     {@link Claim }
     *     
     */
    public void setClaim(Claim value) {
        this.claim = value;
    }

}
