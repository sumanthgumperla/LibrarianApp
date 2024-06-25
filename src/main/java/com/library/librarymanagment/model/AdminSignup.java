package com.library.librarymanagment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AdminSignup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer adminId;
    String name;
    String email;
    Integer mobile;
    String dob;
    String password;



}
