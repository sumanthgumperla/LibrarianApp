package com.library.librarymanagment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AdminDetails {
    @Id
    public Integer adminId;
    public String name;
    public String password;
    public String dob;
    public Integer mobile;






}
