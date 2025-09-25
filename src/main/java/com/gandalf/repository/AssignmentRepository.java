package com.gandalf.repository;

import com.gandalf.entities.InventoryAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<InventoryAssignment,Integer> {

}