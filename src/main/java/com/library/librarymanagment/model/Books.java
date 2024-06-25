package com.library.librarymanagment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

@Entity
public class Books {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
  private  Integer bookId;
    private String bookname;
    private String bookauthor;
    private  String bookprice;
    private String bookbranch;
    private boolean isavalable;


}
