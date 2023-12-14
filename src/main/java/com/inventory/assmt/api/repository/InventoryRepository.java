package com.inventory.assmt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.assmt.api.entity.CompositeKey;
import com.inventory.assmt.api.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, CompositeKey>{
	

}
