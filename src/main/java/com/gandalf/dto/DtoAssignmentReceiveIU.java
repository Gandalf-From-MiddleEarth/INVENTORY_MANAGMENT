package com.gandalf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class  DtoAssignmentReceiveIU {

    private LocalDate returnDate;

    private Integer receiver;
}
