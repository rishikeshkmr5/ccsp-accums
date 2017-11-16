package com.ccsp.accums.utilization.dto;

public class UtilizationPeriodDetailDTO {

    private String period;
	
	private Long planPeriodUtilization;
	
	private Long planPeriodLimit;
	
	private Long accumsRemaining;

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Long getPlanPeriodUtilization() {
		return planPeriodUtilization;
	}

	public void setPlanPeriodUtilization(Long planPeriodUtilization) {
		this.planPeriodUtilization = planPeriodUtilization;
	}

	public Long getPlanPeriodLimit() {
		return planPeriodLimit;
	}

	public void setPlanPeriodLimit(Long planPeriodLimit) {
		this.planPeriodLimit = planPeriodLimit;
	}

	public Long getAccumsRemaining() {
		return accumsRemaining;
	}

	public void setAccumsRemaining(Long accumsRemaining) {
		this.accumsRemaining = accumsRemaining;
	}
	
	
}
