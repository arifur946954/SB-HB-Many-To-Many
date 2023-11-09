package com.jpa.JpaCrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;
    @Column(name = "first_name")
    private String firstNamne;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    public Student() {
    }

    public Student(String firstNamne, String lastName, String email) {
        this.firstNamne = firstNamne;
        this.lastName = lastName;
        this.email = email;
    }
    
}