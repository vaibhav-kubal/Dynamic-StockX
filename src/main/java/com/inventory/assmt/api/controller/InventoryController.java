	package com.inventory.assmt.api.controller;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.inventory.assmt.api.helper.DataHelper;
	import com.inventory.assmt.api.helper.InventoryModel;
	import com.inventory.assmt.api.service.InventoryService;
	import com.inventory.assmt.api.service.ValidationService;
	
	@RestController
	@RequestMapping("/inventory")
	public class InventoryController {
	
	
	
		@Autowired
		ValidationService validationservice;
	
		@Autowired
		InventoryService inventoryservice;
		
		@Autowired
		DataHelper datahelper;
		
		
	
		@GetMapping("/sa-in")
		public ResponseEntity<String> saInventory(@RequestParam String partNumber, @RequestParam String serialNumber, @RequestParam int quantity)
		{
			ResponseEntity<String> response=new ResponseEntity<String>("OK",HttpStatus.OK);
			if(validationservice.validateinput(partNumber, serialNumber, quantity))
			{
				//TODO
				inventoryservice.saIN(partNumber, serialNumber, quantity);
			}
			else
			{
				response=new ResponseEntity<String>("Fail",HttpStatus.BAD_REQUEST);
			}
	
			return response;
		}
	
	
		@GetMapping("/sa-out")
		public ResponseEntity<String> saOutInventory(@RequestParam String partNumber, @RequestParam String serialNumber, @RequestParam int quantity)
		{
			ResponseEntity<String> response=new ResponseEntity<String>("OK",HttpStatus.OK);
			if(validationservice.validateinput(partNumber, serialNumber, quantity))
			{
				//to do
				response=new ResponseEntity<String>(inventoryservice.saOUT(partNumber, serialNumber, quantity),HttpStatus.OK);
			}
			else
			{
				response=new ResponseEntity<String>("Fail", HttpStatus.BAD_REQUEST);
			}
			return response;
		}
		
		@PostMapping("/addinventory")
		public ResponseEntity<String> add(@RequestBody InventoryModel inventorymodel)
		{
			
			ResponseEntity<String> response=new ResponseEntity<String>("OK",HttpStatus.OK);
			datahelper.addData(inventorymodel);
			
			return response;
		}
		
		@GetMapping("/get")
		public ResponseEntity<List<InventoryModel>> getall()
		{
			return new ResponseEntity<List<InventoryModel>>(inventoryservice.getall(),HttpStatus.OK);
	
		}
	
	}
