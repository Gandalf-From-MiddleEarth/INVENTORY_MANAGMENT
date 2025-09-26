package com.gandalf.controller;

import com.gandalf.dto.DtoAssignment;
import com.gandalf.dto.DtoAssignmentCreateIU;
import com.gandalf.dto.DtoAssignmentReceiveIU;

public interface IRestAssignmentController {
    public DtoAssignment createAssignment(DtoAssignmentCreateIU assignment);
    public DtoAssignment receiveAssignment(DtoAssignmentReceiveIU receiveAssignment, Integer id);
    public DtoAssignment getAllAssignments();
}