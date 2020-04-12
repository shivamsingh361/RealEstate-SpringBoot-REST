package com.cg.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="property")
public class Property{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	//@SequenceGenerator(name="myseq",sequenceName="prop_id") 
	@Column(name="prop_id")
	private  int propId;
	
	@Column(name="prop_price")
	private String propPrice;
	
	@Column(name="prop_description")
	private String propDescription;
	
	@Column(name="prop_type")
	private String propType;
	
	@Column(name="house_no")
	private String houseNo;
	
	@Column(name="district")
	private String district;
	
	@Column(name="pin")
	private String pin;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;

	@Column(name="prop_landmark")
	private String landmark;

	@Column(name="owner_contact")
	private String ownerContact;
	
	public Property() {
		super();
	}

	public Property(String propPrice, String propDescription, String propType, String houseNo, String district, String pin,
			String city, String state, String landmark, String ownerContact) {
		super();
		this.propPrice = propPrice;
		this.propDescription = propDescription;
		this.propType = propType;
		this.houseNo = houseNo;
		this.district = district;
		this.pin = pin;
		this.city = city;
		this.state = state;
		this.landmark = landmark;
		this.ownerContact = ownerContact;
	}

	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public String getPropPrice() {
		return propPrice;
	}

	public void setPropPrice(String propPrice) {
		this.propPrice = propPrice;
	}

	public String getPropDescription() {
		return propDescription;
	}

	public void setPropDescription(String propDescription) {
		this.propDescription = propDescription;
	}

	public String getPropType() {
		return propType;
	}

	public void setPropType(String propType) {
		this.propType = propType;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getOwnerContact() {
		return ownerContact;
	}

	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}

	@Override
	public String toString() {
		return "Property [propId=" + propId + ", propPrice=" + propPrice + ", propDescription=" + propDescription
				+ ", propType=" + propType + ", houseNo=" + houseNo + ", district=" + district + ", pin=" + pin + ", city="
				+ city + ", state=" + state + ", landmark=" + landmark + ", ownerContact=" + ownerContact + "]";
	}
	
}
