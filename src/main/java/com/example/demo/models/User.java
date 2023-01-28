package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
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
    private String email;
    @Column(name = "username")
    @NotEmpty(message = "Fill your username")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "Fill your password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> taskList;



    public User(String name, String surname,String username, Date birth, String gender, String country, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.birth = birth;
        this.gender = gender;
        this.country = country;
        this.email = email;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
