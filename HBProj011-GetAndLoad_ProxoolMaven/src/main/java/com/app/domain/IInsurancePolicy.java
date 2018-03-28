package com.app.domain;

public interface IInsurancePolicy {
	public void setPolicyId(int id);
	public int getPolicyId();
	public void setPolicyName(String policyName);
	public String getPolicyName();
	public void setTenure(int tenure);
	public int getTenure();
	public void setPremium(int premium);
	public int getPremium();
}
