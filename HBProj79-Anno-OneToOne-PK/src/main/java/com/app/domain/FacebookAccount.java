package com.app.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="facebook_account_tab")
public class FacebookAccount {
	@Id
	@Column(name="fb_id")
	private int fbId;
	private String name;
	private int followers;
	@OneToOne(targetEntity=UberAccount.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="facebookDetails")
	private UberAccount uberDetails;
	public int getFbId() {
		return fbId;
	}
	public void setFbId(int fbId) {
		this.fbId = fbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public UberAccount getUberDetails() {
		return uberDetails;
	}
	public void setUberDetails(UberAccount uberDetails) {
		this.uberDetails = uberDetails;
	}
}
