package com.gandalf.controller.impl;

import com.gandalf.controller.IRestInventoryController;
import com.gandalf.dto.DtoInventoryManagement;
import com.gandalf.dto.DtoInventoryManagementIU;
import com.gandalf.service.IInventoryManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/inventory")
public class RestInventoryControllerImpl implements IRestInventoryController {

    @Autowired
    private IInventoryManagementService inventoryManagementService;

    @PostMapping(path = "/save")
    @Override
    public DtoInventoryManagement saveInventory(@RequestBody @Valid DtoInventoryManagementIU saveItem) {
        return inventoryManagementService.saveInventory(saveItem);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoInventoryManagement> getAllInventory() {
        return  inventoryManagementService.getAllInventory();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoInventoryManagement getInventoryById(@PathVariable(name = "id") Integer id) {
        return null;
    }

    @Override
    public DtoInventoryManagement updateInventory(DtoInventoryManagement updateInventory, Integer id) {
        return null;
    }
}
