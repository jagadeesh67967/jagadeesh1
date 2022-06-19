package com.zensar.springcoupen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


//@NamedQueries(value = {  @NamedQuery(name = "Coupon.test", query = "from Coupon c where c.couponCode=?1"),
//@NamedQuery(name = "Coupon.test1", query = "from Coupon c where c.couponCode=?1 And c.expDate=?2")})

//@NamedNativeQueries(value = { @NamedNativeQuery(name = "Coupon.test", query = "select * from coupon c where c.coupon_code=?1",resultClass = Coupon.class),
//@NamedNativeQuery(name = "Coupon.test1", query = "select * from coupon c where c.coupon_code=?1 and c.exp_date=?2",resultClass = Coupon.class)})
@Entity
public class Coupen {
	@Id
	private int coupenId;
	private String expDate;
	private String coupenCode;
	
	public Coupen() {
		super();
	}

	public Coupen(int coupenId, String expDate, String coupenCode) {
		super();
		this.coupenId = coupenId;
		this.expDate = expDate;
		this.coupenCode = coupenCode;
	}

	public int getCoupenId() {
		return coupenId;
	}

	public void setCoupenId(int coupenId) {
		this.coupenId = coupenId;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getCoupenCode() {
		return coupenCode;
	}

	public void setCoupenCode(String coupenCode) {
		this.coupenCode = coupenCode;
	}

	@Override
	public String toString() {
		return "Coupen [coupenId=" + coupenId + ", expDate=" + expDate + ", coupenCode=" + coupenCode + "]";
	}
	
	
	

}
