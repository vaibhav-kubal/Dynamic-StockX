package com.inventory.assmt.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.assmt.api.helper.InventoryModel;

@Service
public interface InventoryService {
	
	
	public boolean saIN(String partNumber, String serialNumber, double quantity);
	
	public String saOUT(String partNumber, String serialNumber, double quantity);

	public boolean isAvailable(String partNumber, String serialNumber, int quantity);
	
	public List<InventoryModel> getall();

}
