package com.gandalf.controller;

import com.gandalf.dto.DtoInventoryManagement;
import com.gandalf.dto.DtoInventoryManagementIU;

import java.util.List;

public interface IRestInventoryController {

    public DtoInventoryManagement saveInventory(DtoInventoryManagementIU saveItem);
    public List<DtoInventoryManagement> getAllInventory();
    public  DtoInventoryManagement getInventoryById(Integer id);
    public DtoInventoryManagement updateInventory (Integer id, DtoInventoryManagementIU updateInventory);
}
