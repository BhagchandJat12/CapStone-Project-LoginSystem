package com.loginsystem.userevents.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// Create table for User
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private int Age;

    
    @Column(nullable = false)
    private String Gender;

    @Column(nullable = false,unique = true)
    private String Email;

    @Column(nullable = false)
    private String Password;

    public User() {
    }

    public User(int id, String name, int age, String gender, String email,
            String password) {
        Id = id;
        Name = name;
        Age = age;
        Gender = gender;
        Email = email;
        Password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return  Id+"" ;
    }

    
    
}
