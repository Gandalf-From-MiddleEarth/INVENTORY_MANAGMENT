package com.gandalf.service;

import com.gandalf.dto.DtoInventoryManagement;
import com.gandalf.dto.DtoInventoryManagementIU;
import com.gandalf.entities.Inventory;

import java.util.List;

public interface IInventoryService {
    public DtoInventoryManagement saveInventory(DtoInventoryManagementIU saveInventory);
    public List<DtoInventoryManagement> getAllInventory();
    public  DtoInventoryManagement getInventoryById(Integer id);
    public Inventory updateInventory (DtoInventoryManagement updateInventory, Integer id);
}
