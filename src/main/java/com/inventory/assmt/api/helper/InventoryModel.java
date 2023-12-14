package com.inventory.assmt.api.helper;

public class InventoryModel {
	
	private String partNumber;
	private String serialNumber;
	private Double inventoryQty;
	private Double availableQty;
	private Double allocatedQty;
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
	public Double getInventoryQty() {
		return inventoryQty;
	}
	public void setInventoryQty(Double inventoryQty) {
		this.inventoryQty = inventoryQty;
	}
	public Double getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(Double availableQty) {
		this.availableQty = availableQty;
	}
	public Double getAllocatedQty() {
		return allocatedQty;
	}
	public void setAllocatedQty(Double allocatedQty) {
		this.allocatedQty = allocatedQty;
	}
	
	

}
