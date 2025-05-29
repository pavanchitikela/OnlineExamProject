package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SACTIONED_DETAILS database table.
 * 
 */
@Entity
@Table(name="SANCTIONED_DETAILS")
@NamedQuery(name="SanctionedDetail.findAll", query="SELECT s FROM SanctionedDetail s")
public class SanctionedDetail implements Serializable {
	@Override
	public String toString() {
		return "SanctionedDetail [accountNo=" + accountNo + ", balanceAmount=" + balanceAmount + ", emi=" + emi
				+ ", sanctionedAmount=" + sanctionedAmount + "]";
	}

	private static final long serialVersionUID = 1L;

	
	//private int applicationid;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_generator")
    @SequenceGenerator(name = "my_generator", sequenceName = "MY_SEQUENCE",  allocationSize = 1)
	@Column(name="ACCOUNT_NO")//,columnDefinition = /*"int8 DEFAULT nextval('MY_SEQUENCE"*/ "NUMBER(3,0) DEFAULT MY_SEQUENCE.nextval")
			    /*
			     * @Column(columnDefinition = "int8 DEFAULT nextval('sensor_seq')", insertable = false)
			     */
	private int accountNo;

	@Column(name="BALANCE_AMOUNT")
	private float balanceAmount;

	private float emi;

	@Column(name="SANCTIONED_AMOUNT")
	private float sanctionedAmount;

	//bi-directional one-to-one association to ApplicationDetail
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@MapsId
	@JoinColumn(name="APPLICATIONID"/*, insertable=false, updatable=false*/)
	private ApplicationDetail applicationDetail;

	public SanctionedDetail() {
	}

//	public int getApplicationid() {
//		return this.applicationid;
//	}
//
//	public void setApplicationid(int applicationid) {
//		this.applicationid = applicationid;
//	}

	public int getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public float getBalanceAmount() {
		return this.balanceAmount;
	}

	public void setBalanceAmount(float balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public float getEmi() {
		return this.emi;
	}

	public void setEmi(float emi) {
		this.emi = emi;
	}

	public float getSanctionedAmount() {
		return this.sanctionedAmount;
	}

	public void setSanctionedAmount(float sanctionedAmount) {
		this.sanctionedAmount = sanctionedAmount;
	}

	public ApplicationDetail getApplicationDetail() {
		return this.applicationDetail;
	}

	public void setApplicationDetail(ApplicationDetail applicationDetail) {
		this.applicationDetail = applicationDetail;
	}

}