package com.gandalf.repository;

import com.gandalf.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryManagementRepository extends JpaRepository<Inventory,Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM hrapp.inventory WHERE status != 'ASSIGNED'" )
    List<Inventory> notAssigned();

    Optional<Object> findById(Long id);
}