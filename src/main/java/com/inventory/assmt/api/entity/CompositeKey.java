package com.inventory.assmt.api.entity;

import java.io.Serializable;

public class CompositeKey implements Serializable {
	
	private String partNumber;
	private String serialNumber;
	
	public CompositeKey()
	{
		
	}
	
	
	
	public CompositeKey(String partNumber, String serialNumber) {
		super();
		this.partNumber = partNumber;
		this.serialNumber = serialNumber;
	}
	
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	

}
