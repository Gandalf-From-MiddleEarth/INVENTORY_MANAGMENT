package com.gandalf.service.impl;

import com.gandalf.dto.DtoInventoryManagement;
import com.gandalf.dto.DtoInventoryManagementIU;
import com.gandalf.entities.Inventory;
import com.gandalf.repository.InventoryRepository;
import com.gandalf.service.IInventoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements IInventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public DtoInventoryManagement saveInventory(DtoInventoryManagementIU saveInventory) {
        DtoInventoryManagement response = new DtoInventoryManagement();
        Inventory inventory = new Inventory();
        BeanUtils.copyProperties(saveInventory, inventory);
        Inventory dbInventory = inventoryRepository.save(inventory);
        BeanUtils.copyProperties(dbInventory, response);
        return  response;
    }

    @Override
    public List<DtoInventoryManagement> getAllInventory() {
        List<DtoInventoryManagement> response = new ArrayList<>();
        List<Inventory> inventory = inventoryRepository.findAll();
        for (Inventory inventoryItem : inventory) {
            DtoInventoryManagement responseItem = new DtoInventoryManagement();
            BeanUtils.copyProperties(inventoryItem, responseItem);
            response.add(responseItem);
        }
        return response;
    }

    @Override
    public DtoInventoryManagement getInventoryById(Integer id) {
        DtoInventoryManagement response = null;
        Optional<Inventory> responseItem = inventoryRepository.findById(id);
        if (responseItem.isPresent()) {
            response = new DtoInventoryManagement();
            BeanUtils.copyProperties(responseItem.get(), response);
        }
        return response;
    }

    @Override
    public DtoInventoryManagement updateInventory(DtoInventoryManagementIU updateInventory, Integer id) {
        Optional<Inventory> optional = inventoryRepository.findById(id);
        if (optional.isPresent()) {
            Inventory inventory = optional.get();
            BeanUtils.copyProperties(updateInventory, inventory);
            Inventory savedInventory = inventoryRepository.save(inventory);
            DtoInventoryManagement response = new DtoInventoryManagement();
            BeanUtils.copyProperties(savedInventory, response);

            return response;
        }
        return null;
    }

}