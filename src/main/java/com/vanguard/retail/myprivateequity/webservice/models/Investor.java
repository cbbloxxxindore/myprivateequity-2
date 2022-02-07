package com.vanguard.retail.myprivateequity.webservice.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Entity
@Table(name = "Ret_private_equity_investor")
public class Investor {

	@NotBlank
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int investorId;
	@NotNull
	private String versionId;
	@NotNull
	private String poid;
	
	private String vbaAccountNumber;
	
	private String investorStatus;
	
	private LocalDateTime endDate;
	
	 private String  limitedPartnerId;

	 private String investorLegalName;
		

	 private String investorShortName;
		

	 private String parentLongName;
		

	 private String parentInvestorId;
		



}
