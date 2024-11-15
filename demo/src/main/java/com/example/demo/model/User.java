package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// creating entitiy
@Entity //
@NoArgsConstructor
@AllArgsConstructor// for create table
public class User {
    @Id
private int id;
private String name;
}
