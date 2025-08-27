package com.gandalf.controller;

import com.gandalf.dto.DtoAssignment;
import com.gandalf.dto.DtoAssignmentIU;

public interface IRestAssignmentController {
    public DtoAssignment createAssignment(DtoAssignmentIU assignment);
    public DtoAssignment receiveAssignment(DtoAssignmentIU receiveAssignment, Long id);

}