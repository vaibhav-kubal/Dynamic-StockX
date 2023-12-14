package com.inventory.assmt.api.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService{

	public boolean validateinput (String partNumber, String serialNumber, int quantity)
	{
		boolean valid=false;
		
		if (!partNumber.isEmpty() && !serialNumber.isEmpty() && quantity >0)
		{
			valid=true;
		}
		
		return valid;	
	}
}
