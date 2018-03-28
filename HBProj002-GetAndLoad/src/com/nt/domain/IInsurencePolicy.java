package com.nt.domain;

public interface IInsurencePolicy {
	public void setPolicyId(int policyId);
	public int getPolicyId();
	public void setPolicyName(String policyName);
	public String getPolicyName();
	public void setTenure(int tenure);
	public int getTenure();
	public void setPremium(int premium);
	public int getPremium();
}
