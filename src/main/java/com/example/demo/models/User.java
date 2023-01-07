package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    @NotEmpty(message = "Fill your name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birth")
    private Date birth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "country")
    private String country;

    @Column(name = "email")
    @Email(message = "Enter correct email")
    @NotEmpty(message = "Fill your email")
    private String email;
    @Column(name = "password")
    @NotEmpty(message = "Fill your password")
    private String password;

    @Column(name = "exp_date")
    private Date exp_date;

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }

    public User() {
    }

    public User(String name, String surname, Date birth, String gender, String country, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.gender = gender;
        this.country = country;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
