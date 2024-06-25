package com.library.librarymanagment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class IssueBook {
    @Id
    private Integer bookId;
    private Integer studentId;
    private String issueDate;
    private boolean isReturned;

}
