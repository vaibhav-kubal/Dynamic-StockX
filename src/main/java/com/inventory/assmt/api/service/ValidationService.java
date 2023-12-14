package com.inventory.assmt.api.service;

import org.springframework.stereotype.Service;

@Service
public interface ValidationService{
	
	//input validation 
	
	public boolean validateinput (String partNumber, String serialNumber, int quantity);
	
	
	

}
