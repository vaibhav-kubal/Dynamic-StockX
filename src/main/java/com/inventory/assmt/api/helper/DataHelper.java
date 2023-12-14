package com.inventory.assmt.api.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventory.assmt.api.entity.Inventory;
import com.inventory.assmt.api.repository.InventoryRepository;

@Component
public class DataHelper {

	@Autowired
	InventoryRepository inventoryrepository;
	
	public void addData(InventoryModel inventorymodel)
	{
		Inventory i1=new Inventory();
		i1.setPartNumber(inventorymodel.getPartNumber());
		i1.setSerialNumber(inventorymodel.getSerialNumber());
		i1.setInventoryQty(inventorymodel.getInventoryQty());
		i1.setAvailableQty(inventorymodel.getAvailableQty());
		i1.setAllocatedQty(inventorymodel.getAllocatedQty());
		
		inventoryrepository.save(i1);
	}
}
