package com.example.claim;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Claim {
	
	private Long id;
	private String number;
	private String policy;
	private Date date;
		
	private Calendar cal;
	
	public Claim(){
		
	}
	
	public Claim(Long id, String number, String policy, Calendar cal){
		this.id = id;
		this.number = number;
		this.policy = policy;
		this.cal = cal;
		this.date = cal.getTime();
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}	
	
	

}
