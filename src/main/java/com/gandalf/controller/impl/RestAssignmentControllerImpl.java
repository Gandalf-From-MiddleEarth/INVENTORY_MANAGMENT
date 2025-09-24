package com.gandalf.controller.impl;

import com.gandalf.controller.IRestAssignmentController;
import com.gandalf.dto.DtoAssignment;
import com.gandalf.dto.DtoAssignmentIU;
import com.gandalf.service.IAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/assignment")
public class RestAssignmentControllerImpl implements IRestAssignmentController {

    @Autowired
    private IAssignmentService assignmentService;

    @PostMapping(path = "/create")
    @Override
    public DtoAssignment createAssignment(@RequestBody DtoAssignmentIU assignment) {
        return assignmentService.createAssignment(assignment);
    }

    @PutMapping(path = "/receive/{id}")
    @Override
    public DtoAssignment receiveAssignment(@RequestBody DtoAssignmentIU receiveAssignment,@PathVariable(name = "id") Long id) {
        return assignmentService.receiveAssignment(receiveAssignment, id);
    }

    @GetMapping("/list")
    @Override
    public DtoAssignment getAllAssignments() {
        return assignmentService.getAllAssignments();
    }
}