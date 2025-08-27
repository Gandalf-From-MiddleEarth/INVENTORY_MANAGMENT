package com.gandalf.service;

import com.gandalf.dto.DtoAssignment;
import com.gandalf.dto.DtoAssignmentIU;

public interface IAssignmentService {

    public DtoAssignment createAssignment(DtoAssignmentIU assignment);
    public DtoAssignment receiveAssignment(DtoAssignmentIU receiveAssignment, Long id);
}