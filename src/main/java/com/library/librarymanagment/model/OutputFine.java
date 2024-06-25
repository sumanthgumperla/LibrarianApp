package com.library.librarymanagment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OutputFine {
    private Integer bookId;
    private Integer studentId;
    private String issueDate;
    private boolean isReturned;
    private Long fine;
}
