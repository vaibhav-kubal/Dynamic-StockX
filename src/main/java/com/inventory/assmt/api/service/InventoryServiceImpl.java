package com.inventory.assmt.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.assmt.api.entity.CompositeKey;
import com.inventory.assmt.api.entity.Inventory;
import com.inventory.assmt.api.helper.InventoryModel;
import com.inventory.assmt.api.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryrepository;

	@Override
	public boolean saIN(String partNumber, String serialNumber, double quantity) {
		Inventory inventory=new Inventory();

		CompositeKey composite=new CompositeKey(partNumber, serialNumber);

		try
		{
			inventory=inventoryrepository.findById(composite).get();
		
		

		if(inventory!=null)
		{
			inventory.setAvailableQty(inventory.getAvailableQty()+quantity);
			inventory.setInventoryQty(inventory.getInventoryQty()+quantity);
			inventoryrepository.save(inventory);
		}
		
		}
		catch(NoSuchElementException ex)
		{
			inventory=new Inventory();
			inventory.setPartNumber(partNumber);
			inventory.setSerialNumber(serialNumber);
			inventory.setAvailableQty(quantity);
			inventory.setInventoryQty(quantity);
			inventory.setAllocatedQty(0.0);
			inventoryrepository.save(inventory);
		}

		return true;
	}

	@Override
	public String saOUT(String partNumber, String serialNumber, double quantity) {
		Inventory inventory=new Inventory();

		CompositeKey composite=new CompositeKey(partNumber, serialNumber);

		

		try
		{
			inventory=inventoryrepository.findById(composite).get();
			
			if(inventory!=null)
			{
				if(quantity>inventory.getInventoryQty())
				{
					return "Quantity exceeds available quantity";
				}
				else if(inventory.getInventoryQty()>0)
				{
					inventory.setAvailableQty(inventory.getAvailableQty()-quantity);
					inventory.setInventoryQty(inventory.getInventoryQty()-quantity);
					inventoryrepository.save(inventory);
					
					//update and check if quantity is zero
					if(inventory.getInventoryQty()==0)
					{
						inventoryrepository.delete(inventory);
					}
				}
				
				else
				{
					return "Insufficient inventory";
				}	
			}
		}
		catch(NoSuchElementException e)
		{
			return "Inventory does not exist";
		}
		
		return "OK";
	}

	@Override
	public boolean isAvailable(String partNumber, String serialNumber, int quantity) {
		return false;
	}

	@Override
	public List<InventoryModel> getall() {
		
		List<InventoryModel> response=new ArrayList<InventoryModel>();
		
		for(Inventory i1: inventoryrepository.findAll())
		{
			InventoryModel im=new InventoryModel();
			im.setPartNumber(i1.getPartNumber());
			im.setSerialNumber(i1.getSerialNumber());
			im.setInventoryQty(i1.getInventoryQty());
			im.setAvailableQty(i1.getAvailableQty());
			im.setAllocatedQty(i1.getAllocatedQty());
			
			response.add(im);
		}
		
		return response;
	}

}
