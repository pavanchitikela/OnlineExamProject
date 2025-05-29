package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PROPERTY_DETAILS database table.
 * 
 */
@Entity
@Table(name="PROPERTY_DETAILS")
@NamedQuery(name="PropertyDetail.findAll", query="SELECT p FROM PropertyDetail p")
public class PropertyDetail implements Serializable {
	@Override
	public String toString() {
		return "PropertyDetail [applicationid=" + applicationid + ", propertyCost=" + propertyCost
				+ ", propertyLocation=" + propertyLocation + ", propertyName=" + propertyName + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	private int applicationid;

	@Column(name="PROPERTY_COST")
	private float propertyCost;

	@Column(name="PROPERTY_LOCATION")
	private String propertyLocation;

	@Column(name="PROPERTY_NAME")
	private String propertyName;

	//bi-directional one-to-one association to ApplicationDetail
	@OneToOne//(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name="APPLICATIONID")
	private ApplicationDetail applicationDetail;

	public PropertyDetail() {
	}

	public int getApplicationid() {
		return this.applicationid;
	}

	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}

	public float getPropertyCost() {
		return this.propertyCost;
	}

	public void setPropertyCost(float propertyCost) {
		this.propertyCost = propertyCost;
	}

	public String getPropertyLocation() {
		return this.propertyLocation;
	}

	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public ApplicationDetail getApplicationDetail() {
		return this.applicationDetail;
	}

	public void setApplicationDetail(ApplicationDetail applicationDetail) {
		this.applicationDetail = applicationDetail;
	}

}