package com.gandalf.controller.impl;

import com.gandalf.controller.IRestInventoryController;
import com.gandalf.dto.DtoInventoryManagement;
import com.gandalf.dto.DtoInventoryManagementIU;
import com.gandalf.service.IInventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/inventory")
public class RestInventoryControllerImpl implements IRestInventoryController {

    @Autowired
    private IInventoryService inventoryService;

    @PostMapping(path = "/save")
    @Override
    public DtoInventoryManagement saveInventory(@RequestBody @Valid DtoInventoryManagementIU saveItem) {
        return inventoryService.saveInventory(saveItem);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoInventoryManagement> getAllInventory() {
        return  inventoryService.getAllInventory();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoInventoryManagement getInventoryById(@PathVariable(name = "id") Integer id) {
        return inventoryService.getInventoryById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoInventoryManagement updateInventory(@PathVariable(name = "id") Integer id, @RequestBody DtoInventoryManagementIU updateInventory) {
        return inventoryService.updateInventory(updateInventory, id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public boolean deleteInventory(@PathVariable(name = "id") Integer id){
        return inventoryService.deleteInventory(id);
    }

}
